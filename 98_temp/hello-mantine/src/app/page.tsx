import { Button, Center, Stack, Text, Title } from "@mantine/core";

export default function Home() {
  return (
    <Center h="100vh">
      <Stack align="center" gap="lg">
        <Title order={1}>Hello World!</Title>
        <Text c="dimmed" size="lg">
          Built with Next.js and Mantine
        </Text>
        <Button size="md" variant="filled">
          Get Started
        </Button>
      </Stack>
    </Center>
  );
}
