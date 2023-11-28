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

#SHELL7 打印字母数小于8的单词
awk -F" " '{for(i=1;i<=NF;i++){if(length($i) < 8){print $i}}}' nowcoder.txt

#SHELL8 统计所有进程占用内存百分比的和
awk '{SUM+=$4}END{print SUM}' nowcoder.txt

#SHELL9 统计每个单词出现的个数
#xargs 转为单行输出
#sort 将结果按照字符大小排序
#uniq 统计重复行
#sort 对第 1 列统计结果排序
#awk 换行输出
cat nowcoder.txt | xargs -n1 | sort | uniq -c | sort -n | awk '{print $2, $1}'

#SHELL10 第二列是否有重复
#先用awk提取文本的第二列信息
# 对之进行排序，
# 排序后才能用uniq进行去重统计（先去重统计在排序会造成统计不准确），
# 再用grep把没有重复的取反求出（没有重复数值就是1），最后按题目要求再次按数值排序！！！
# uniq https://baike.baidu.com/item/uniq/10654799
cat nowcoder.txt | awk '{print $2}' | sort | uniq -c | grep -v '1' | sort -n

#SHELL11 转置文件的内容
awk '{
    for(i=1;i<=NF;i++){
      if(NR==1){
        row[i] = $i;
      }else{
        row[i] = row[i]" "$i;
      }
    }
}END{
  for(i=1;i<=NF;i++){
    print row[i]
  }
}
' ./nowcoder.txt

#SHELL12 打印每一行出现的数字个数
awk -F "[1,2,3,4,5]" 'BEGIN{sum=0}{print "line"NR" number:"(NF-1);sum+=(NF-1)}END{print "sum is "sum}' nowcoder.txt

#SHELL13 去掉所有包含this的句子
grep -v this

#SHELL14 求平均值
awk '{
    for(i=1;i<=NF;i++){
      if(NR==1){
        row[0] = $i;
      }else{
        row[1] = row[1]+$i;
      }
    }
}END{
    printf("%.3f",row[1]/row[0]);
}
'
#SHELL15 去掉不需要的单词
grep -v b | grep -v B

#SHELL16 判断输入的是否为IP地址
awk -F "." '{if(NF!=4){printf("error\n");next;}for(i=1;i<=4;i++){if($i<0 || $i>255){printf("no\n");next;}if(i==NF){printf("yes\n")}}}' nowcoder.txt

#SHELL17 将字段逆序输出文件的每行 -F 分割 NF 是列
awk -F":" '{for(i=NF;i>=1;i--) {if(i==1){printf("%s\n",$i)} else {printf("%s:",$i)}} }' nowcoder.txt

#SHELL18 域名进行计数排序处理 -r 倒序
awk -F"/" '{printf("%s\n",$3)}' | sort | uniq -c | sort -r | awk '{print $1, $2}'

#SHELL19 打印等腰三角形
read n
for ((i=1;i<=n;i++))
do
    #打印空格
    for ((j=n-i;j>=1;j--))
    do
        printf " "
    done
    #打印*
    for ((k=1;k<=i;k++))
    do
        printf "* "
    done
    #换行
    printf "\n"
done

#SHELL20 打印只有一个数字的行
awk -F"[0-9]" '{if(NF==2)print $0}'

#SHELL21 格式化输出 length 长度 substr 截取
awk '{
l=length($0)
f=l%3
for (i=1;i<=l;i++){
    printf substr($0,i,1)
    if((i-f)%3==0 && i!=l)
        printf ","
}
print ""
}' nowcoder.txt

#SHELL22 处理文本
awk -F ":" '{
        a[$1] = a[$1] $2 "\n"
    }
    END {for (i in a){
        printf("[%s]\n%s",i,a[i])
        }
    }' nowcoder.txt

#SHELL23 Nginx日志分析1-IP访问次数统计
grep "23/Apr/2020" |awk -F"-" '{printf("%s\n",$1)}' |sort | uniq -c | sort -r | awk '{print $1,$2}'

#SHELL24 Nginx日志分析2-统计某个时间段的IP访问量
grep "23/Apr/2020:2[0-3]" | awk '{print $1}' | sort | uniq | wc -l

#SHELL25 nginx日志分析3-统计访问3次以上的IP
awk '{print($1)}' | sort | uniq -c|sort -r| awk '{if($1>3) print $1,$2}'