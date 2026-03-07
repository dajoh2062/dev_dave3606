using System;

class Test
{
    static int Square(int x)
    {
        return x * x;
    }

    static void Main()
    {
        int a = 5;
        double b = 3.14;
        string name = "C#";
        bool flag = true;

        if (flag)
        {
            Console.WriteLine($"{name} square: {Square(a)}");
        }

        for (int i = 0; i < 3; i++)
        {
            Console.WriteLine($"i = {i}");
        }
    }
}
