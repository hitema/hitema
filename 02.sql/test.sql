/***********************************************************************************/

/*
select s.ID_step, s.process, s.name from step s, role r 
where s.ID_step = r.ID_step and r.username = 'DRH' and r.type_role = 1000
 order by process_order;


select s.ID_step, s.process, s.name from step s, role r 
where s.ID_step = r.ID_step and r.username = 'ARH' and r.type_role = 1000
 order by process_order;

*/

/*  identifier si un user peut initialiser un workflow */
select s.ID_Step, s.process, s.name from step s, role r where s.process_order = 1 and r.ID_step = s.ID_step and r.username = 'DRH' and r.type_role = 1000;

/* list des actions possibles selon le username *//
select distinct r.type_role from role r where r.username = 'DRH' order by type_role;

/***********************************************************************************/

select s.ID_step, s.name from step s, role r
where s.ID_step = r.ID_step and r.username = 'ARH' and type_role = 1000 and
process = 'EMBAUCHE' and process_order = 2;


/* get the next step with the username*/

select w.last_step+1, s.type_role from workflow w, step_role s
where w.ID_process = s.process and s.username = 'ARH' and
w.ID_process ='EMBAUCHE' 
and w.last_step+1 < (select max(process_order) from step where process = 'EMBAUCHE');



select max(process_order) from step where process ='EMBAUCHE';







/*get the next step */
select w.last_step+1 from workflow w
where w.ID_workflow = 1 
and w.last_step+1 <= (select max(process_order) from step where process = w.ID_Process);


select s.ID_Step, s.name, r.type_role from step s, role r
where  s.ID_Step = r.ID_Step
and s.ID_step = 2 and s.process ='EMBAUCHE' and s.process_order = 2
and r.username = 'ARH';

select type_role from role where username = 'ARH' and ID_step = 2;




select s.process_order, r.type_role
from workflow w, step s, role r
where w.ID_process = s.process and s.ID_step = r.ID_step
and r.username = 'ARH' and ID_Workflow = 1;


/*******MENU**************************/
select distinct w.ID_workflow, w.last_step, w.ID_process,w.information
from workflow w, step s, role r
where w.ID_process = s.process and s.ID_step = r.ID_step
and r.username = 'ARH' and w.last_step = s.process_order



select distinct s.ID_step, s.process_order, r.type_role, s.name
from role r, step s 
where r.ID_step = s.ID_step 
and username = 'DRH' and process  ='EMBAUCHE' and s.process_order = 2;





