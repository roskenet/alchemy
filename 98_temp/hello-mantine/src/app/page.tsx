"use client";

import { useState } from "react";
import { Button, Center, Stack, Text, Title } from "@mantine/core";


export default function Home() {
  const [count, setCount] = useState(0);

  function doSomething() {
      setCount(count + 1);
      console.log("count", count);
  }

  return (
    <Center h="100vh">
      <Stack align="center" gap="lg">
        <Title order={1}>Hello World!</Title>
        <Text c="dimmed" size="lg">
          Built with Next.js and Mantine
        </Text>
        <Text size="xl" fw={700}>
          Count: {count}
        </Text>
        <Button
          size="md"
          variant="filled"
          onClick={() => {doSomething(); console.log("clicked");}}
        >
          Get Started
        </Button>
      </Stack>
    </Center>
  );
}
