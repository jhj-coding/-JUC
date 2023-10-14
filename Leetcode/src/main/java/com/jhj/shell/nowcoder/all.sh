#SHELL1 统计文件的行数 wc 命令用于统计文件字节（-c）、字符（-m）、单词（-w）与行（-l）的数量。
# | 是将前一个命令结果给后一个命令
# awk 是一个脚本 $1 第一个字段
#https://blog.csdn.net/sinat_32152141/article/details/125133897
#https://zhuanlan.zhihu.com/p/627048291?utm_id=0
wc -l nowcoder.txt | awk '{print $1}'

#tail 显示尾部几行
#sed 命令打印第几行 https://blog.csdn.net/Logicr/article/details/112845375
tail -n 5 nowcoder.txt
#SHELL3 输出 0 到 500 中 7 的倍数
#空格不能少
b=0;
while [ $b -le 500 ]
    do
        echo $b
        let b+=7;
    done

# SHELL4 输出第5行的内容
head -n 5  nowcoder.txt  | tail -n 1
sed -n 5p

#SHELL5 打印空行的行号 grep 搜索 -n 显示行号 不过有个： awk-F 加符号 通过什么分割 awk NR 行号
grep -n '^$' nowcoder.txt | awk -F: '{print $1}'
awk '/^$/ {print NR}'

#SHELL6 去掉空行 grep https://www.cnblogs.com/ggjucheng/archive/2013/01/13/2856896.html
awk NF
grep -v '^$'
