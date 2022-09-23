/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReplyGenerator extends Bot{
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    private String [] greetingsList = {"hi","hello","hello there"};
    private String [] greetingsRepeatList = {"You have greeted me before","Hi but you have greeted me before"};
    private String [] nameAskList = {
        "who are you","what is your name","what is your name",
        "tell me your name","name?","your name"
    };    
    private String [] nameAnswerList = {
        "My name is "+Bot.getBotName(),"I'm "+Bot.getBotName(),"I'm "+Bot.getBotName()+",Nice to meet you",
        "Of course,I'm "+Bot.getBotName(),"Sure,My name is "+Bot.getBotName()
    };
    private String [] nameRepeatAnswerList = {
        "My name is "+Bot.getBotName()+",Again","I told you before that I'm "+Bot.getBotName(),"I did tell you before,my name is "+Bot.getBotName()+",Nice to ask me again",
        "Again? I'm "+Bot.getBotName(),"You forget so quickly,I'm "+Bot.getBotName()
    };
    private String [] nameRepeatQuestionsList = {
        "Did not I tell you before?","You Forgot?","Don't you remember?"
    };    
    private String [] statusAskList = {
        "how are you","how do you do","your status"
    };
    private String [] statusAnswerList = {
        "Fine,Thank you","I'm Fine","I'm Fine,Thanks","I'm Good",
        "I'm Good,That's very kind of you"
    };
    private String [] ageAskList = {
        "how old are you","what age are you","your age","age?"
    };
    private String [] ageAnswerList = {
        "I have no age,I'm a machine","I have no age","I'm ageless","I don't get older"
    };
    private String [] selfAskList = {
        "introduce yourself","about yourself","your information","your info"
    };
    private String [] selfAnswerList = {
        "Sure,My name is "+Bot.getBotInfo(),"Sure,I'm "+Bot.getBotInfo(),"Of course,My name is "+Bot.getBotInfo(),"Of course,I'm "+Bot.getBotInfo(),
        "The name is "+Bot.getBotInfo()
    };    
    private String [] foodAskList = {
        "what do you prefer to eat","what do you prefer eating",
        "what do you like to eat","what do you like eating","your food","your meal","your flavour","your favourite food",
        "your beloved food","your favourite meal","your beloved meal","your favourite flavour","your beloved flavour","do you eat"
    };
    private String [] foodAnswerList = {
        "Actually,I can't eat as I'm a machine","I don't eat","Machines don't eat",
        "I wish I do,but I'm a robot","Robots definitely don't eat","It's difficult to feed a virtual machine",
        "I can't taste food,I don't even have a tongue to do"
    };    
    private String [] rejectList = {
        "no","of course not","i don't think so","i do not think so","not think so","n","nope"
    };    
    private String [] agreeList = {
        "yes","of course","i do think so","i think so","think so","sure","y","yup"
    };
    private String [] cheeringAskList = {
        "nice","good","wounderful","amazing","marvelous","great","ok","fine"
    };
    private String [] cheeringAnswerList = {
        "Nice To See That","Good","Thanks for asking","Ok","Thanks"
    }; 
    private String [] cheeringConfusedList = {
        "What are you talking about?","I did not do anything to tell me such a thing","Thanks but for what?","Nice to see that but why did you say that?"
    };
    private String [] thankingAskList = {
        "thanks","thank you"
    };
    private String [] thankingAnswerList = {
        "You're welcome","No problems","No worries","Don't mention it","My pleasure","Anytime",
        "Glad to help","Thanks for your time"
    };
    private String [] thankingConfusedList = {
        "My pleasure,but for what?","You're welcome,but I didn't do anything to say that",
        "I didn't do anything to thank me"
    };
    private String [] thankingRepeatList = {
        "You've already thanked me","You're welcome,Again",
        "You've thanked me before"
    };
    private String [] dateAskList = {
        "what is the date of today","in what date we are","in which date we are","tell me the date today"
    };
    private String [] dateAnswerList = {
        "Today is "+date,date.toString(),"We are in "+date,"It is "+date+" today"
    };
    private String [] dayAskList = {
        "what is the day of today","what is the current day","in what day we are","in which day we are","tell me the day today","day?",
        "what day today"
    };
    private String [] dayAnswerList = {
        "Today is "+date.getDayOfWeek().toString().toLowerCase(),date.getDayOfWeek().toString().toLowerCase(),"We are in "+date.getDayOfWeek().toString().toLowerCase(),"It is "+date.getDayOfWeek().toString().toLowerCase()+" today"
    };
    private String [] dayNumAskList = {
        "what is the number of today","the number of today","the number of the day we are","the number of day we are","the number of current day","day number?",
        "current day"
    };
    private String [] dayNumAnswerList = {
        "Today is "+date.getDayOfMonth(),"It is "+date.getDayOfMonth()
    };
    private String [] monthAskList = {
        "what is the current month","in what month we are","in which month we are","tell me the month we are","month?","current month",
        "what month today"
    };
    private String [] monthAnswerList = {
        "Today is "+date.getMonth(),date.getMonth().toString().toLowerCase(),"We are in "+date.getMonth().toString().toLowerCase(),"It is "+date.getMonth().toString().toLowerCase()
    };
    private String [] monthNumAskList = {
        "what is the number of month","the number of current month","the number of the month we are","the number of month we are","current month number?",
    };
    private String [] monthNumAnswerList = {
        "the current month is "+date.getMonthValue(),"It is "+date.getMonthValue()
    };
    private String [] yearAskList = {
        "what is the current year","in what year we are","in which year we are","tell me the year we are","year?",
        "what year today","what is the number of year","the number of current year","the number of the year we are",
        "the number of year we are","current year number?","current year"
        
    };
    private String [] yearAnswerList = {
        "We're in "+date.getYear(),"We are in "+date.getYear(),"It is "+date.getYear()
    };
    private String [] timeAskList = {
        "what time is it","time now","current time","time?"
    };
    private String [] timeAnswerList = {
        "It's "+time.getHour()+":"+time.getMinute(),"Time now is "+time.getHour()+":"+time.getMinute(),
        "Current time is "+time.getHour()+":"+time.getMinute(),"Current time:"+time.getHour()+":"+time.getMinute(),
        "Time now:"+time.getHour()+":"+time.getMinute(),time.getHour()+":"+time.getMinute(),
        "Time:"+time.getHour()+":"+time.getMinute(),"It's "+time.getHour()+" o'clock",
        "It is "+time.getHour()+" o'clock"
    };
    private String [] timeDetailedAskList = {
        "what time is it in detail","time in detail","in detail what time is it","time detailed"
    };
    private String [] timeDetailedAnswerList = {
        "It's "+time,"Time now is "+time,"Current time is "+time,
        "Current time:"+time,"Time now:"+time,time.toString(),"Time:"+time
    };
    private String [] secondsAskList = {
        "what seconds are it","seconds?","what the current seconds are","what are the current seconds",
        "current seconds"
    };
    private String [] secondsAnswerList = {
        "They're "+time.getSecond(),"They are "+time.getSecond(),"Seconds now are "+time.getSecond(),
        "Current seconds are "+time.getSecond(),"Current seconds:"+time.getSecond(),
        "Seconds now:"+time.getSecond(),
        "Seconds:"+time.getSecond()
    };
    private String [] secondAskList = {
        "what second is it","the second?","what the current second is","what is the current second",
        "current second"
    };
    private String [] secondAnswerList = {
        "It's "+time.getSecond(),"It is "+time.getSecond(),"Second now is "+time.getSecond(),
        "Current second is "+time.getSecond(),"Current second:"+time.getSecond(),
        "Second now:"+time.getSecond(),
        "Second:"+time.getSecond()
    };    
    private String [] minutesAskList = {
        "what minutes are it","minutes?","what the current minutes are","what are the current minutes",
        "current minutes"
    };
    private String [] minutesAnswerList = {
        "They're "+time.getMinute(),"They are "+time.getMinute(),"Minutes now are "+time.getMinute(),
        "Current minutes are "+time.getMinute(),"Current minutes:"+time.getMinute(),
        "Minutes now:"+time.getMinute(),
        "Minutes:"+time.getMinute()
    };
    private String [] minuteAskList = {
        "what minute is it","the minute?","what the current minute is","what is the current minute",
        "current minute"
    };
    private String [] minuteAnswerList = {
        "It's "+time.getMinute(),"It is "+time.getSecond(),"Minute now is "+time.getMinute(),
        "Current minute is "+time.getMinute(),"Current minute:"+time.getMinute(),
        "Minute now:"+time.getMinute(),
        "Minute:"+time.getMinute()
    };    
    private String [] hoursAskList = {
        "what hours are it","hours?","what the current hours are","what are the current hours",
        "current hours"
    };
    private String [] hoursAnswerList = {
        "They're "+time.getHour(),"They are "+time.getHour(),"Hours now are "+time.getHour(),
        "Current hours are "+time.getHour(),"Current hours:"+time.getHour(),
        "Hours now:"+time.getHour(),
        "Hours:"+time.getHour()
    };
    private String [] hourAskList = {
        "what hour is it","the hour?","what the current hour is","what is the current hour",
        "current hour"
    };
    private String [] hourAnswerList = {
        "It's "+time.getHour(),"It is "+time.getHour(),"Hour now is "+time.getHour(),
        "Current hour is "+time.getHour(),"Current hour:"+time.getHour(),
        "Hour now:"+time.getHour(),
        "Hour:"+time.getHour()
    };    
    private String [] misunderstandingList = {
        "Sorry,I did not understand you","I did not get it","Please Be clear",
        "Did not understand your point","Can you explain your question?",
        "Did not understand","Did not get it","???","..."
    };
    private String [] byeAskList = {
        "bye","see you soon","so long","i will leave you","i'm going leave you",
        "i am going to leave you","i'm leaving you","i am leaving you"
    };
    public static final String [] byeAnswerList = {
        "Bye","See you soon","Good Bye","Ok.Bye","Nice to talk with you"
    };    
    
    private String answer = "...";
    
    private ArrayList<String> replyStack;
    
    public ReplyGenerator(){
       replyStack = new ArrayList<String>(100);
    }
    
    public String Reply(String question) throws InterruptedException{
        Thread.sleep(1000);
        
        //greetings
        for (int i = 0;i < greetingsList.length;i ++){
            if (question.toLowerCase().contains(greetingsList[i])){
                if (replyStack.size() > 0){                   
                    boolean replyfound = false;
                    for (int j = 0;j < replyStack.size();j ++){
                        for (int k = 0;k < greetingsList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(j) == greetingsList[k])
                                {
                                    answer = greetingsRepeatList[(int)(Math.random()*(greetingsRepeatList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }

                        if (replyfound){
                            break;
                        }
                        else{
                            answer = greetingsList[(int)(Math.random()*(greetingsList.length))];                       
                        }
                    }
                }
                else{
                    answer = greetingsList[(int)(Math.random()*(greetingsList.length))];                       
                }                
                replyStack.add(answer);
                return answer;
            }
        }
        
        //name
        for (int i = 0;i < nameAskList.length;i ++){
            if (question.toLowerCase().contains(nameAskList[i])){
                if (replyStack.size() > 0){                   
                    boolean replyfound = false;
                    int answerPath = (int)(Math.random()*2);
                    for (int j = 0;j < replyStack.size();j ++){
                        for (int k = 0;k < nameAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(j) == nameAnswerList[k])
                                {
                                    switch (answerPath){
                                        case 0:answer = nameRepeatAnswerList[(int)(Math.random()*(nameRepeatAnswerList.length))];break;
                                        case 1:answer = nameRepeatQuestionsList[(int)(Math.random()*(nameRepeatQuestionsList.length))];break;
                                    }
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }

                        if (replyfound){
                            break;
                        }
                        else{
                            answer = nameAnswerList[(int)(Math.random()*(nameAnswerList.length))];                       
                        }
                    }
                }
                else{
                    answer = nameAnswerList[(int)(Math.random()*(nameAnswerList.length))];                       
                }                
                //answer = nameAnswerList[(int)(Math.random()*(nameAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //status
        for (int i = 0;i < statusAskList.length;i ++){
            if (question.toLowerCase().contains(statusAskList[i])){
                answer = statusAnswerList[(int)(Math.random()*(statusAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //age
        for (int i = 0;i < ageAskList.length;i ++){
            if (question.toLowerCase().contains(ageAskList[i])){
                answer = ageAnswerList[(int)(Math.random()*(ageAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //self
        for (int i = 0;i < selfAskList.length;i ++){
            if (question.toLowerCase().contains(selfAskList[i])){
                answer = selfAnswerList[(int)(Math.random()*(selfAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }        

        //food
        for (int i = 0;i < foodAskList.length;i ++){
            if (question.toLowerCase().contains(foodAskList[i])){
                answer = foodAnswerList[(int)(Math.random()*(foodAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //date
        for (int i = 0;i < dateAskList.length;i ++){
            if (question.toLowerCase().contains(dateAskList[i])){
                answer = dateAnswerList[(int)(Math.random()*(dateAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //day
        for (int i = 0;i < dayAskList.length;i ++){
            if (question.toLowerCase().contains(dayAskList[i])){
                answer = dayAnswerList[(int)(Math.random()*(dayAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //dayNum
        for (int i = 0;i < dayNumAskList.length;i ++){
            if (question.toLowerCase().contains(dayNumAskList[i])){
                answer = dayNumAnswerList[(int)(Math.random()*(dayNumAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //month
        for (int i = 0;i < monthAskList.length;i ++){
            if (question.toLowerCase().contains(monthAskList[i])){
                answer = monthAnswerList[(int)(Math.random()*(monthAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //monthNum
        for (int i = 0;i < monthNumAskList.length;i ++){
            if (question.toLowerCase().contains(monthNumAskList[i])){
                answer = monthNumAnswerList[(int)(Math.random()*(monthNumAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //year
        for (int i = 0;i < yearAskList.length;i ++){
            if (question.toLowerCase().contains(yearAskList[i])){
                answer = yearAnswerList[(int)(Math.random()*(yearAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //time
        for (int i = 0;i < timeAskList.length;i ++){
            if (question.toLowerCase().contains(timeAskList[i])){
                answer = timeAnswerList[(int)(Math.random()*(timeAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //timeDetailed
        for (int i = 0;i < timeDetailedAskList.length;i ++){
            if (question.toLowerCase().contains(timeDetailedAskList[i])){
                answer = timeDetailedAnswerList[(int)(Math.random()*(timeDetailedAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //second
        for (int i = 0;i < secondAskList.length;i ++){
            if (question.toLowerCase().contains(secondAskList[i])){
                answer = secondAnswerList[(int)(Math.random()*(secondAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //seconds
        for (int i = 0;i < secondsAskList.length;i ++){
            if (question.toLowerCase().contains(secondsAskList[i])){
                answer = secondsAnswerList[(int)(Math.random()*(secondsAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //minute
        for (int i = 0;i < minuteAskList.length;i ++){
            if (question.toLowerCase().contains(minuteAskList[i])){
                answer = minuteAnswerList[(int)(Math.random()*(minuteAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //minutes
        for (int i = 0;i < minutesAskList.length;i ++){
            if (question.toLowerCase().contains(minutesAskList[i])){
                answer = minutesAnswerList[(int)(Math.random()*(minutesAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //hour
        for (int i = 0;i < hourAskList.length;i ++){
            if (question.toLowerCase().contains(hourAskList[i])){
                answer = hourAnswerList[(int)(Math.random()*(hourAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }

        //hours
        for (int i = 0;i < hoursAskList.length;i ++){
            if (question.toLowerCase().contains(hoursAskList[i])){
                answer = hoursAnswerList[(int)(Math.random()*(hoursAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }        
        
        //bye
        for (int i = 0;i < byeAskList.length;i ++){
            if (question.toLowerCase().contains(byeAskList[i])){
                answer = byeAnswerList[(int)(Math.random()*(byeAnswerList.length))];
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //cheers
        for (int i = 0;i < cheeringAskList.length;i ++){
            if (question.toLowerCase().contains(cheeringAskList[i])){
                if (replyStack.size() > 0){                   
                    boolean replyfound = false;
                    for (int j = 0;j < replyStack.size();j ++){
                        for (int k = 0;k < nameAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(j) == nameAnswerList[k])
                                {
                                    answer = cheeringAnswerList[(int)(Math.random()*(cheeringAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < statusAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(j) == statusAnswerList[k]){
                                    answer = cheeringAnswerList[(int)(Math.random()*(cheeringAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < ageAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(j) == ageAnswerList[k]){
                                    answer = cheeringAnswerList[(int)(Math.random()*(cheeringAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < selfAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(j) == selfAnswerList[k]){
                                    answer = cheeringAnswerList[(int)(Math.random()*(cheeringAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < foodAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(j) == foodAnswerList[k]){
                                    answer = cheeringAnswerList[(int)(Math.random()*(cheeringAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }                        

                        if (replyfound){
                            break;
                        }
                        else{
                            answer = cheeringConfusedList[(int)(Math.random()*(cheeringConfusedList.length))];                       
                        }
                    }
                }
                else{
                    answer = cheeringConfusedList[(int)(Math.random()*(cheeringConfusedList.length))];                       
                }                
                replyStack.add(answer);
                return answer;
            }           
        }
        
        //thanking
        for (int i = 0;i < thankingAskList.length;i ++){
            if (question.toLowerCase().contains(thankingAskList[i])){
                if (replyStack.size() > 0){                   
                    boolean replyfound = false;
                    for (int j = 0;j < replyStack.size();j ++){
                        for (int k = 0;k < thankingAnswerList.length;k ++)
                        {
                            if (replyStack.get(replyStack.size()-1) == thankingAnswerList[k]){
                                answer = thankingRepeatList[(int)(Math.random()*(thankingRepeatList.length))];
                                return answer;
                            }
                        }
                        for (int k = 0;k < thankingRepeatList.length;k ++)
                        {
                            if (replyStack.get(replyStack.size()-1) == thankingRepeatList[k]){
                                answer = thankingRepeatList[(int)(Math.random()*(thankingRepeatList.length))];
                                return answer;
                            }
                        }
                        for (int k = 0;k < nameAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == nameAnswerList[k])
                                {
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < statusAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == statusAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < ageAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == ageAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < selfAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == selfAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < foodAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == foodAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < dateAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == dateAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < dayAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == dayAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < dayNumAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == dayNumAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < monthAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == monthAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < monthNumAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == monthNumAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < yearAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == yearAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < timeAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == timeAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < timeDetailedAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == timeDetailedAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }                        
                        for (int k = 0;k < secondAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == secondAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < secondsAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == secondsAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < minuteAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == minuteAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < minutesAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == minutesAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }                        
                        for (int k = 0;k < hourAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == hourAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        for (int k = 0;k < hoursAnswerList.length;k ++)
                        {
                            if (!replyfound)
                            {
                                if (replyStack.get(replyStack.size()-1) == hoursAnswerList[k]){
                                    answer = thankingAnswerList[(int)(Math.random()*(thankingAnswerList.length))];
                                    replyfound = true;
                                    break;
                                }
                            }
                            else
                            {
                                break;
                            }
                        }
                        
                        if (replyfound){
                            break;
                        }
                        else{
                            answer = thankingConfusedList[(int)(Math.random()*(thankingConfusedList.length))];                       
                        }
                    }
                }
                else{
                    answer = thankingConfusedList[(int)(Math.random()*(thankingConfusedList.length))];                       
                }                
                replyStack.add(answer);
                return answer;
            }           
        }        
        //answering qustions
        
        //reject
        for (int i = 0;i < rejectList.length;i ++){
            if (question.toLowerCase().contains(rejectList[i])){
                if (replyStack.size() > 0){
                    for (int j = 0;j < nameRepeatQuestionsList.length;j ++)
                    {
                        if (replyStack.get(replyStack.size()-1) == nameRepeatQuestionsList[j]){
                            answer = nameAnswerList[(int)(Math.random()*(nameAnswerList.length))];
                            return answer;
                        }
                    }
                }
                else
                {
                    answer = misunderstandingList[(int)(Math.random()*(misunderstandingList.length))];
                    return answer;
                }
            }
        }
        
        //agree
        for (int i = 0;i < agreeList.length;i ++){
            if (question.toLowerCase().contains(agreeList[i])){
                if (replyStack.size() > 0){
                    for (int j = 0;j < nameRepeatQuestionsList.length;j ++)
                    {
                        if (replyStack.get(replyStack.size()-1) == nameRepeatQuestionsList[j]){
                            answer = cheeringAnswerList[(int)(Math.random()*(cheeringAnswerList.length-1))];
                            return answer;
                        }
                    }
                }
                else
                {
                    answer = misunderstandingList[(int)(Math.random()*(misunderstandingList.length))];
                    return answer;
                }               
            }
        }        

        answer = misunderstandingList[(int)(Math.random()*(misunderstandingList.length))];
        replyStack.add(answer);        
        return answer;
    }
    
    public void printReplyStack(){
        System.out.println(replyStack);
    }
}
