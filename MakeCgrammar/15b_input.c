int main()
{
   double payments_cost,payments_left;
   double total = 0;
   printf("What is your biweekly car payment?\n");
   scanf("%d",&payments_cost);
   printf("How many weeks do you have left?\n");
   scanf("%d",&payments_left);
   int i = 0;
   while (i <= payments_left)
   {
      i++;
      total = total + payments_cost;
   }
   printf("You have $%d left to pay off!\n",total);
   return 0;
}
