%This is my salter function

function y = salter(x,y)
    for i = 1:length(x)
        if rand > .66
            y(i) = randi([1, y(end)]);
        end
    end
end