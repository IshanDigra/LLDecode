package SystemDesign.AbstractFactory;

public interface IMovieFactory {
    ITollywoodMovie getTollywoodMovie();
    IBollywoodMovie getBollywoodMovie();
}
