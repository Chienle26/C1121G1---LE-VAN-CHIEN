function fibonacci(num: number): number {
    if (num <= 1) {
        return 1;
    }

    return fibonacci(num - 1) + fibonacci(num - 2);
}

let sum : number = 0;
for (let i = 1; i<10; i++){
    console.log(fibonacci(i));
    sum+= fibonacci(i);
}

console.log(`Tổng dãy số fibonacci là: ${sum}`);