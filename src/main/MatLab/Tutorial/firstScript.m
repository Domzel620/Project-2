%%This is the script written bty following the MatlabTutorial by
% Jousef Murad | Deep Dive, following this video https://youtu.be/tBWMn4y1Yfo?si=DfiSw2iSuqyKGH9Q
% Dominic Zelinsky - April 2025

%3 Magic Cs

clear all %clears all variables in workspace
close all %Closes all current open figures
clc       %Clears the command window

%Loops

counter = 10;

for i = 1:5
    counter = counter + 1;
    disp(counter)
end

while counter >= 5;
    counter = counter - 1;
    disp(counter)
end

%%Ploting

x = 0:0.1:5;
y = x.^2;
plot(x, y,'r+')
title("My First Plot")
xlabel('x-value')
ylabel('y-value')
grid on
hold on%Hold prevents the plot from being overwritten
y2 = x.^3%Allowing you to add more plots to it
y3 = x.^4
plot(x, y2, "g*")
plot(x, y3, "b^")
hold off
legend('Plot 1', 'Plot 2', 'Plot 3')

%%SubPlotting
subplot(311)
plot(x,y)
subplot(312)
plot(x,y2)
subplot(313)
plot(x,y3)

%Calling my Function
triangle_area(5,10)