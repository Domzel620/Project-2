%%This is the function script for making an exponential function
function [x,y] = expFunc(initialX)
        x = initialX:1:initialX+25;
        y = x.^2;
end
