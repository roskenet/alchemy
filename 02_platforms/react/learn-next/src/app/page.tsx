'use client';

import {
  Container,
  Title,
  Text,
  Button,
  Group,
  Stack,
  Card,
  SimpleGrid,
  Badge,
  Paper,
  TextInput,
  Switch,
  Divider,
  Anchor,
  ThemeIcon,
  rem,
} from '@mantine/core';
import {
  IconBolt,
  IconBrandNextjs,
  IconPalette,
} from '@tabler/icons-react';
import {useState} from 'react';
import Link from 'next/link';
import {ColorSchemeToggle} from '@/components/ColorSchemeToggle';

const features = [
  {
    icon: IconBrandNextjs,
    title: 'Next.js App Router',
    description:
        'Leverage React Server Components, file-system routing, and optimal performance out of the box.',
  },
  {
    icon: IconPalette,
    title: 'Mantine UI v7+',
    description:
        'Over 100 customizable and accessible components with seamless dark/light mode support.',
  },
  {
    icon: IconBolt,
    title: 'Modern TypeScript',
    description:
        'Strict type checking, path aliases configured (@/*), and modern developer tooling.',
  },
];

export default function HomePage() {
  const [inputValue, setInputValue] = useState('');
  const [checked, setChecked] = useState(true);

  return (
      <Container size="lg" py="xl">
        <Stack gap="xl">
          {/* Header / Hero */}
          <Stack align="center" gap="md" ta="center" mt="xl">
            <Badge size="lg" variant="gradient" gradient={{from: 'blue', to: 'cyan'}}>
              Next.js + Mantine Starter
            </Badge>

            <Title order={1} size="h1" fw={900}>
              Welcome to <Text span c="blue" inherit>learn-next</Text>
            </Title>

            <Group>
              <Button component={Link} href="/kata" variant="light">
                Kata Page
              </Button>
            </Group>
            <Group justify="center" gap="md">
              <ColorSchemeToggle/>
            </Group>
          </Stack>

          <Divider my="md"/>

          {/* Feature Cards */}
          <Title order={2} size="h3" ta="center" mb="xs">
            Included Features
          </Title>
          <SimpleGrid cols={{base: 1, sm: 3}} spacing="lg">
            {features.map((feature) => (
                <Card key={feature.title} shadow="sm" padding="lg" radius="md" withBorder>
                  <ThemeIcon size={44} radius="md" variant="light" color="blue" mb="md">
                    <feature.icon style={{width: rem(24), height: rem(24)}}/>
                  </ThemeIcon>
                  <Text fw={600} size="lg" mb="xs">
                    {feature.title}
                  </Text>
                  <Text size="sm" c="dimmed">
                    {feature.description}
                  </Text>
                </Card>
            ))}
          </SimpleGrid>

          {/* Interactive Demo Section */}
          <Paper shadow="xs" p="xl" radius="md" withBorder mt="lg">
            <Title order={3} size="h4" mb="md">
              Interactive Component Showcase
            </Title>
            <SimpleGrid cols={{base: 1, sm: 2}} spacing="lg">
              <Stack gap="md">
                <TextInput
                    label="Sample Input"
                    placeholder="Type something here..."
                    value={inputValue}
                    onChange={(event) => setInputValue(event.currentTarget.value)}
                />
                <Text size="sm" c="dimmed">
                  Input preview: <b>{inputValue || '(empty)'}</b>
                </Text>
              </Stack>

              <Stack gap="md">
                <Switch
                    label="Sample Switch"
                    checked={checked}
                    onChange={(event) => setChecked(event.currentTarget.checked)}
                />
                <Group>
                  <Button variant="filled" color="blue">
                    Primary Action
                  </Button>
                  <Button variant="light" color="blue">
                    Secondary Action
                  </Button>
                  <Button variant="outline" color="gray">
                    Outline
                  </Button>
                </Group>
              </Stack>
            </SimpleGrid>
          </Paper>

          {/* Footer */}
          <Group justify="space-between" mt="xl">
            <Text size="xs" c="dimmed">
              Built with Next.js and Mantine
            </Text>
            <Group gap="xs">
              <Anchor href="https://nextjs.org/docs" size="xs" target="_blank">
                Next.js Docs
              </Anchor>
              <Text size="xs" c="dimmed">
                •
              </Text>
              <Anchor href="https://mantine.dev" size="xs" target="_blank">
                Mantine Docs
              </Anchor>
            </Group>
          </Group>
        </Stack>
      </Container>
  );
}
