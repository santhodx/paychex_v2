# paychex_v2

About

java paychex [OUTPUTFILE]

where OUTPUTFILE is an optional parameter indicating the path to which to write. In the absence of the parameter, the program will write to stdout.

The output is to look like

Payroll, total = $423100
   Department 1, total = $323100
      Employee 1, Developer, $105000
      Employee 2, Manager, $123100
      Department 2, total = $95000
         Employee 3, Developer, $95000
   Department 3, total = $100000
      Employee 4, Developer, $100000
where each department is indented three spaces compared to the previous department. The first line lists “Payroll” as the name of the “department”.
