package SystemDesign.AbstractFactory;

public class ActionMovieFactory implements IMovieFactory{
    @Override
    public ITollywoodMovie getTollywoodMovie() {
        return new TollywoodActionMovie();
    }

    @Override
    public IBollywoodMovie getBollywoodMovie() {
        return new BollywoodActionMovie();
    }
}
