clear all
close all
clc

%% Learned that just calling the function only stores the x value under 'ans'

[x,y] = expFunc(3);



y2 = salter(x,y);
y3 = smoother(x,y2,4);


subplot(3,1,1)
plot(x,y,"r*-")
title("Base Plot")
subplot(3,1,2)
plot(x,y2,"b*-")
title("Salted Plot")
subplot(3,1,3)
plot(x,y3,"*-")
title("Smoothed Plot")