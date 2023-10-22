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