#include <stdio.h>
#include <mpi.h>

int main(int argc, char **argv)
{
    // time
    MPI_Init(&argc, &argv);
    printf("Hola Mundo\n\n");
    MPI_Finalize();
    // time
}
