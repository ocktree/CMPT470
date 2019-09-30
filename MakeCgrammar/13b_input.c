int main()
{
   char selection;
   int luck;
   printf("Please enter a number 1-5 to receive a fortune\n");
   scanf("%c",&selection);
   switch (selection)
   {
      case '1':
         printf("You will have horrible luck today.\n");
         luck = 20;
         break;
      case '2':
         printf("You will have back luck today.\n");
         luck = 40;
         break;
      case '3':
         printf("Your day will be unaffected by luck.\n");
         luck = 60;
         break;
      case '4':
         printf("You will have good luck today!\n");
         luck = 80;
         break;
      case '5':
         printf("You will be very lucky today!\n");
         luck = 100;
         break;
      default:
         printf("You entered an invalid choice\n");
   }
   return 0;
}
