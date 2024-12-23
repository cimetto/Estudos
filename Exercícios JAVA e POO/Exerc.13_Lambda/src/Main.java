public class Main{
    public static void main(String[] args) {

        MathOperation adicao = ((number1, number2) -> number1+number2);
        /*
        Criamos o objeto adicao e adicionamos o lambda, onde recebe 2
        parametros, number1 e number2 para retornar a soma deles
        */
        MathOperation subtracao = ((number1, number2) -> number1-number2);
        MathOperation multiplicacao = ((number1, number2) -> number1*number2);
        MathOperation divisao = ((number1, number2) -> number1/number2);

        System.out.println(adicao.operate(10, 5)); // O objeto adição chama o método operate da interface
        System.out.println(subtracao.operate(20, 8));
        System.out.println(multiplicacao.operate(3, 7));
        System.out.println(divisao.operate(16, 4));
    }
}