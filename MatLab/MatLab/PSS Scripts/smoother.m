

function y = smoother(x,saltedY, windowValue)
    
    for i = 1:length(x)
       max = i+windowValue;
       min = i-windowValue;

       counter = 0;
       sum = 0;

       if min >= 1 && max <= length(x)
           for j = min:max
               sum = sum + saltedY(j);
               counter = counter + 1;
           end
       elseif i >= windowValue && max > length(x)
           for j = min:length(x)
               sum = sum + saltedY(j);
               counter = counter + 1;
           end
       elseif min < 1 && max <= length(x)
           for j = 1:max
               sum = sum + saltedY(j);
               counter = counter + 1;
           end
       elseif min < 1 && max > length(x)
           for j = 1:length(x)
               sum = sum + saltedY(j);
               counter = counter + 1;
           end
       end
       average = sum/counter;
       saltedY(i) = average;

    end
    y = saltedY;
end