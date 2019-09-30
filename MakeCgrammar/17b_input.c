int main()
{
   int factorial, max, min;
   int total = 0;
   max = factorial;
   printf ("Factorial of:\n");
   scanf ("%d",&factorial);
   printf ("Sum factorial down to:\n");
   scanf ("%d",&min);
   while (factorial > 0)
   {
      total = total + factorial;
      factorial--;
      if (factorial == min)
      {
         printf("The sum of your factorial %d down to %d is %d",factorial,min,total);
         break;
      }
   }
   return 0;
}
