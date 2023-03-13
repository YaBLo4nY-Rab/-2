import java.util.Scanner;// пакет для ввода с клавиатуры

public class Main
{
    public static void print_vec(Vector vec)// метод для вывода вектора в консоль
    {
        for (int i = 0; i < vec.get_len(); ++i)
        {
            System.out.print(vec.get_value(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)//основной метод
    {
        Scanner in = new Scanner(System.in);// создание объекта типа сканер, вектор
        Vector vec1 = new Vector(5);
        Vector vec2 = new Vector(5);
        // Ввод
        System.out.println("Введите 1-ый вектор:");//цикл для ввода в консоль верктора
        for (int i = 0; i < vec1.get_len(); ++i)
        {
            int num = in.nextInt();
            vec1.set_value(i,num);
        }

        System.out.println("Введите 2-ой вектор:");//цикл для ввода в консоль верктора 2
        for (int i = 0; i < vec2.get_len(); ++i)
        {
            int num = in.nextInt();
            vec2.set_value(i,num);
        }

        System.out.println("Min :" + vec1.get_min());
        System.out.println("Max:" + vec1.get_max());

        vec1.sort();
        System.out.println("Sort:");
        print_vec(vec1);

        System.out.println("Evklid:"+ vec1.ev_norm());

        vec1.vec_multip(2);//умножение на 2
        System.out.println("Multip:");
        print_vec(vec1);

        vec1.vec_sum(vec2);
        System.out.println("Vec1 + Vec2:");
        print_vec(vec1);

        System.out.println("Scalar:" + vec1.vec_scal(vec2));
    }
}
class Vector
{
    private int n = 0;
    int[] vector;
    public Vector(int n)
    {
        this.n = n;
        vector = new int[n];
    }

    public int get_len()
    {
        return vector.length;
    }
    public int get_value(int i)
    {
        return vector[i];
    }
    public void set_value(int i, int v)
    {
        vector[i] = v;
    }

    public int get_min()
    {
        int min = vector[0];
        for (int i = 0;i < get_len();++i)
        {
            if (vector[i] < min)
            {
                min = vector[i];
            }

        }
        return min;
    }
    public int get_max()
    {
        int max = vector[0];
        for (int i = 0; i < get_len();++i)
        {
            if (vector[i] > max)
            {
                max = vector[i];
            }
        }
        return max;
    }

    public void sort()
    {
        for (int i = 0; i < get_len() - 1; ++i)
        {
            for (int j = 0; j < get_len() - i - 1; ++j)
            {
                if (vector[j] > vector[j + 1])
                {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }
    public double ev_norm()
    {
        int norm = 0;
        for (int i = 0;i < get_len();++i)
        {
            norm += get_value(i) * get_value(i);
        }
        return Math.sqrt(norm);
    }
    public void vec_multip(int x)
    {
        for (int i = 0;i < get_len();++i)
        {
            vector[i] *=  x;
        }
    }
    public void vec_sum(Vector vec)
    {
        for (int i = 0; i < get_len(); ++i)
        {
            vector[i] += vec.get_value(i);
        }
    }
    public int vec_scal(Vector vec)
    {
        int scal = 0;
        for (int i = 0; i < get_len();++i)
        {
            scal += vector[i] * vec.get_value(i);
        }
        return scal;
    }

}
