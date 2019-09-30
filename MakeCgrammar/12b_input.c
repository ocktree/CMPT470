int main()
{
   double temp;
   char cold;
   scanf("%d",&temp);
   if (a >= 25 && a <= 20)
   {
      printf("Today will be between 20 and 25 degrees\n");
      cold = 'n';
   }
   if (a == 0 || a == 1 || a == -1)
   {
      printf("It will be close to zero degrees today! Brrr.\n");
      cold = 'y';
   }
   if ((a != 0) && !(a > -1) || (a < -10))
   {
     printf("It will be really cold today\n");
     cold = 'y';
   }
   return 0;
}
