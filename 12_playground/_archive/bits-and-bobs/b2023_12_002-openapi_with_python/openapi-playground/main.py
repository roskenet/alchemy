# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
from openai import OpenAI

client = OpenAI(api_key='')

def askSomething(message):
    messages = [{"role": "system", "content": "You are a intelligent assistant."}]

    if message:
        messages.append(
            {"role": "user", "content": message},
        )
        chat = client.chat.completions.create(model="gpt-3.5-turbo", messages=messages)

    reply = chat.choices[0].message.content
    print(f"ChatGPT: {reply}")
    messages.append({"role": "assistant", "content": reply})

if __name__ == '__main__':
    askSomething('How did Germany abolished the Monarchy in 1916?')
