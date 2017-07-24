public class Solution {
public int superPow(int a, int[] b) {
long num = 0;
int n = b.length;
int key = 1;
while(Math.pow(a, key) < 1337){
key++;
}
2^100,
for(int i = 0; i < n; ++i){
num += 10*num + b[i];
}
return getMod(a, num, key);
    }
public int getMod(int a, int b, int key){
if(b < key){return Math.pow(a, b);}
if(b % 2 == 0){
return (getMod(a, b / 2, key) * getMode(a, b / 2, key) ) mod 1337;
}
else {
return (getMod(a, b / 2 + 1, key) * getMode(a, b / 2, key) ) mod 1337;
}

}
