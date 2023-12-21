#SQL110 插入记录(一)
insert into exam_record (uid,exam_id,start_time,submit_time,score)values (1001,9001,'2021-09-01 22:11:12','2021-09-01 23:01:12',90),(1002,9002,'2021-09-04 07:01:02',null,null)

#SQL111 插入记录(二)
insert into exam_record_before_2021 (uid,exam_id,start_time,submit_time,score) select uid,exam_id,start_time,submit_time,score from exam_record where submit_time<'2021-01-01 0:0:0'

#SQL112 插入记录(三)
replace into examination_info (exam_id,tag,difficulty,duration,release_time) values(9003,"SQL","hard",90,'2021-01-01 00:00:00')

#SQL113 更新记录(一)
update examination_info set tag="Python" where tag="PYTHON"