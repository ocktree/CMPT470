#include<stdio.h>
#include"hello.c"
#include<math.h>

int main()
{
   int i;
   int double = 1;
   while (i < 50)
   {
      i++;
      double = double*2;
      continue;
   }
   printf("The doubled number is %d\n",double);
   return 0;
}
