# Engcon idea similar to optexity  

The goal is to get familiar with Optexity platform, understand the working and then build one feature.

---

### Setup (10-20 min) -- already done for understanding only. 

1. Visit **https://dashboard.optexity.com**
2. Sign in with an account
3. Complete the **“Get Started”** flow on the dashboard:
    - Record an automation
    - Run an automation
4. Try running an automation **locally**
5. Verify that:
    - The **Tasks** tab gets populated with your runs
    - **Task Analytics** data is generated

---

### Setup for Development (5 min) -- already done for understanding only. 

After you complete the previous steps, setup the environment for local development. Follow the steps exactly as described

1. Fork https://github.com/Optexity/optexity to your own github. (This is needed so that you can commit to your own fork and we can evaluate that)
2. Run git clone on your fork
3. Using the conda env created in previous steps run `pip install -e .` in the cloned fork
4. Fork https://github.com/Optexity/browser-use
5. Run git clone on your fork
6. Using the conda env created in previous steps run `pip install -e .` in the cloned fork

Important: run the fork, and install in the same way otherwise optexity install might override browser use install locally.

Now your setup is ready for development

---

## Background

By now you would have understood that optexity platform runs on a schema for the automation. The schema is stored as a json on the dashboard. This schema has all the instructions for the agent to help it understand what steps to take. This includes running a deterministic playwright code, to web based locators to prompt based instruction.

For the prompt based instruction we use a fork  of browser-use under the hood. How it works is that browser-use converts the website into a readable format which looks something like

```jsx
[59]<a />
		Security
	[61]<a />
		Download
	[63]<a />
		Support
	[65]<a id=show-big-login />
		Log In
	[67]<a id=dlbtn />
		Buy Now
	Form Filler: Test Form - All Fields
	Title
	|SHADOW(open)|[6]<input type=text name=01___title />
	First Name
```

The LLM is given this string and asked to choose which index to click like `[67]` . Then based on that chosen index, it is converted to an action in underlying code which is executed.

So let’s say you are running the task using browser-use using a given prompt and objective, it will always try to figure out from the starting on how to achieve this task. In every new run there is no memory and no learning from previous run. Each step will require LLM reasoning, will use LLM tokens and will consume time.

Now if you observe, lot of steps in any workflow like inputing username and password and clicking on SignIn button are deterministic and we do not need to spend llm tokens on that. We need to use this observation to complete the assignment.

### Objective

Your task is to build a memory layer for these types of actions so that first time agent is given an objective, the LLM (browser-use) will try to figure our how to complete the task. Then based on that logs, you convert the steps to more deterministic actions so that when you run it next time it does not have to figure that out.

Design and build a simple learning framework which runs, the agent, then caches the steps and figures out which are deterministic steps, which were redundant steps (like browser-use can take redundant steps while exploring) and then build a new automation which is more deterministic. If we run this automation, the time it takes for the automation will be less and llm tokens will be less.

For the assignment, you can just log the cache and then manually build the new automation to verify if the actual code based cache is working or not.

**Some Extra Setup (5 min)**

Optexity automations are stored in our database but as you do not have access to it, it will be hard for you to iterate. Hence add the following lines in `optexity/inference/child_process.py` after line 575

```python
from optexity.schema.automation import Automation
with open("test_automation.json", "r") as f:
    automation = json.load(f)
    automation = Automation.model_validate(automation)
task.automation = automation
```

Now you can copy any starting automation in test_automation.json and it will overwrite the one on server so you can just call any automation endpoint on the server but it will pick it up from local.

You can start testing stuff with `https://www.roboform.com/filling-test-all-fields` .

Use the below as starting point for `test_automation.json` agentic task and cache it.

**Final Goals (1-3 hrs)**

```python
{
    "url": "https://www.roboform.com/filling-test-all-fields",
    "parameters": {
      "input_parameters": {
      },
      "generated_parameters": {}
    },
    "nodes": [
      {
        "type": "action_node",
        "interaction_action": {
          "agentic_task": {
            "task": "fill the full name as myname, address line one as xyz and line 2 as abc, city as SF",
            "max_steps": 15,
            "backend": "browser_use"
          }
        }
      }
    ]
  }
```

1. Start from the above agentic task and run it once. You will see browser-use taking actions based on reasoning.
2. Then add a function or logging in browser-use repo which you forked from optexity to cache the steps and make it deterministic playwright code.
3. Use the cached actions to test out a new `test_automation_cached.json` which should be deterministic

The final output should look something like

```python
{
    "url": "https://www.roboform.com/filling-test-all-fields",
    "parameters": {
      "input_parameters": {
      },
      "generated_parameters": {}
    },
    "nodes": [
      {
        "type": "action_node",
        "interaction_action": {
          "input_text": {
            "command": "locator(\"something\").first",
            "prompt_instructions": "Enter fullname in the field",
            "input_text": "fullname"
          }
        }
      },
      {
        "type": "action_node",
        "interaction_action": {
          "input_text": {
            "command": "locator(\"something\").first",
            "prompt_instructions": "Enter address in the field",
            "input_text": "xyz"
          }
        }
      },
      {
        "type": "action_node",
        "interaction_action": {
          "input_text": {
            "command": "locator(\"something\").first",
            "prompt_instructions": "Enter address line2 in the field",
            "input_text": "abc"
          }
        }
      }
    ]
  }
```

You can create this file manually from hand but the values in the commands should be sourced from what you derive from the caching and not made up

1. Test this out on any one extra website of your choice or your task. Example task can be navigating to a page and downloading a file. You can skip websites which give you captcha.

NOTE:

Please pick the extra website as multi step workflow like navigating page, clicks which changes page and not just another single page form filling.

---

## Submission

1. Create a new branch in your own fork and commit everything to that branch in your fork in optexity and browser-use and share the.
2. Open a PR from your branch to your own fork main branch.
3. Submit the PR link/links

Please do not open a PR to optexity main repo.

---

### Evaluation Criteria

You will be evaluated on:

- **Code quality**
- **Latency / performance**
- **Extra features or enhancements**
- **Time taken to build**

During the demo of this assignment, you will be asked questions around your code decisions

---

### Bonus

- Instead of manually building the output automation from the cache logs, build it automatically by using the LLM, optexity docs, pydantic validation and the cache logs
- Instead of single one time caching, do it in a loop where you start from simple agentic task, browser-use takes some actions, you cache it and use it to rebuild automation, run it again in a loop, recache it and iteratively make it better and improve performance.

---

## Help

docs.optexity will come in handy.
