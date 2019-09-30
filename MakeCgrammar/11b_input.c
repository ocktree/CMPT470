int main()
{
   int temp;
   char cold;
   scanf("%d",&temp);
   if (temp <= 20)
   {
      cold = 'y';
      printf("It's flippen cold outside today!\n");
      printf("The temperature is %d", temp);
   }
   else
   {
      pass = 'n';
      printf("It's not cold outside today!\n");
      printf("The temperature is %d", temp);
   }
   return 0;
}
