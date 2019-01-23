#include <stdio.h>

typedef struct Student {     // 사람
    char name[20]; // 이름
    int score;     // 점수
} Student;

int main() {
    Student classA[10] = {
        {"김김김", 44},
        {"김김김", 92},
        {"김김김", 75},
        {"김김김", 56},
        {"김김김", 68},
        {"김김김", 89},
        {"김김김", 90},
        {"김김김", 88},
        {"김김김", 68},
        {"김김김", 69},
    };
    Student classB[10] = {
        {"손손손", 78},
        {"손손손", 65},
        {"손손손", 87},
        {"손손손", 76},
        {"손손손", 88},
        {"손손손", 44},
        {"손손손", 45},
        {"손손손", 77},
        {"손손손", 96},
        {"손손손", 44},
    };

    int max = 0;
    int min = 100;
    int sum = 0;
    float avg = 0;
    for (int i = 0; i < 10; i++) {
        if (max < classA[i].score) {
            max = classA[i].score;
        } else if (min > classA[i].score) {
            min = classA[i].score;
        }
        sum += classA[i].score;
    }
    avg = (float) sum / 10.0f;
    printf("1반 : 최대 %d , 최소 %d, 합 %d, 평균 %g \n", max, min, sum, avg);

    max = 0;
    min = 100;
    sum = 0;
    avg = 0;
    for (int i = 0; i < 10; i++) {
        if (max < classB[i].score) {
            max = classB[i].score;
        } else if (min > classB[i].score) {
            min = classB[i].score;
        }
        sum += classB[i].score;
    }
    avg = (float) sum / 10.0f;
    printf("1반 : 최대 %d , 최소 %d, 합 %d, 평균 %g \n", max, min, sum, avg);

    return 0;
}