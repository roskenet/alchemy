'use client';

import { Button, Group, useMantineColorScheme } from '@mantine/core';
import { IconSun, IconMoon, IconDeviceDesktop } from '@tabler/icons-react';

export function ColorSchemeToggle() {
  const { setColorScheme } = useMantineColorScheme();

  return (
    <Group justify="center" gap="sm">
      <Button
        variant="default"
        leftSection={<IconSun size={16} />}
        onClick={() => setColorScheme('light')}
      >
        Light
      </Button>
      <Button
        variant="default"
        leftSection={<IconMoon size={16} />}
        onClick={() => setColorScheme('dark')}
      >
        Dark
      </Button>
      <Button
        variant="default"
        leftSection={<IconDeviceDesktop size={16} />}
        onClick={() => setColorScheme('auto')}
      >
        Auto
      </Button>
    </Group>
  );
}
