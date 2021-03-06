/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package resolved;

import unresolved.UnresolvedClass;

// This class is defined by the child class loader, so access to
// package-private classes and members defined in the parent class
// loader is illegal even though the package name is the same.
public class SubclassOfUnresolvedClass2 extends UnresolvedClass {
  public static void $noinline$main() {
    $noinline$testResolvedPublicClass();
    $noinline$testResolvedPackagePrivateClass();

    $noinline$testPublicFieldInResolvedPackagePrivateClass();
    $noinline$testPublicFieldInPackagePrivateClassViaResolvedPublicSubclass();
    $noinline$testPrivateFieldInResolvedPackagePrivateClass();
    $noinline$testPrivateFieldInPackagePrivateClassViaResolvedPublicSubclass();
    $noinline$testPackagePrivateFieldInResolvedPackagePrivateClass();
    $noinline$testPackagePrivateFieldInPackagePrivateClassViaResolvedPublicSubclass();

    $noinline$testPublicMethodInResolvedPackagePrivateClass();
    $noinline$testPublicMethodInPackagePrivateClassViaResolvedPublicSubclass();
    $noinline$testPrivateMethodInResolvedPackagePrivateClass();
    $noinline$testPrivateMethodInPackagePrivateClassViaResolvedPublicSubclass();
    $noinline$testPackagePrivateMethodInResolvedPackagePrivateClass();
    $noinline$testPackagePrivateMethodInPackagePrivateClassViaResolvedPublicSubclass();

    System.out.println("SubclassOfUnresolvedClass2 passed");
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testResolvedPublicClass() builder (after)
  /// CHECK: LoadClass class_name:resolved.ResolvedPublicSubclassOfPackagePrivateClass needs_access_check:false
  static void $noinline$testResolvedPublicClass() {
    Class<?> c = ResolvedPublicSubclassOfPackagePrivateClass.class;
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testResolvedPackagePrivateClass() builder (after)
  /// CHECK: LoadClass class_name:resolved.ResolvedPackagePrivateClass needs_access_check:true
  static void $noinline$testResolvedPackagePrivateClass() {
    try {
      Class<?> c = ResolvedPackagePrivateClass.class;
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicFieldInResolvedPackagePrivateClass() builder (after)
  /// CHECK: UnresolvedStaticFieldSet

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicFieldInResolvedPackagePrivateClass() builder (after)
  /// CHECK-NOT: StaticFieldSet
  static void $noinline$testPublicFieldInResolvedPackagePrivateClass() {
    try {
      ResolvedPackagePrivateClass.publicIntField = 42;
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicFieldInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK: StaticFieldSet

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicFieldInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK-NOT: UnresolvedStaticFieldSet
  static void $noinline$testPublicFieldInPackagePrivateClassViaResolvedPublicSubclass() {
    ResolvedPublicSubclassOfPackagePrivateClass.publicIntField = 42;
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateFieldInResolvedPackagePrivateClass() builder (after)
  /// CHECK: UnresolvedStaticFieldSet

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateFieldInResolvedPackagePrivateClass() builder (after)
  /// CHECK-NOT: StaticFieldSet
  static void $noinline$testPrivateFieldInResolvedPackagePrivateClass() {
    try {
      ResolvedPackagePrivateClass.privateIntField = 42;
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateFieldInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK: UnresolvedStaticFieldSet

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateFieldInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK-NOT: StaticFieldSet
  static void $noinline$testPrivateFieldInPackagePrivateClassViaResolvedPublicSubclass() {
    try {
      ResolvedPublicSubclassOfPackagePrivateClass.privateIntField = 42;
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateFieldInResolvedPackagePrivateClass() builder (after)
  /// CHECK: UnresolvedStaticFieldSet

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateFieldInResolvedPackagePrivateClass() builder (after)
  /// CHECK-NOT: StaticFieldSet
  static void $noinline$testPackagePrivateFieldInResolvedPackagePrivateClass() {
    try {
      ResolvedPackagePrivateClass.intField = 42;
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateFieldInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK: UnresolvedStaticFieldSet

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateFieldInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK-NOT: StaticFieldSet
  static void $noinline$testPackagePrivateFieldInPackagePrivateClassViaResolvedPublicSubclass() {
    try {
      ResolvedPublicSubclassOfPackagePrivateClass.intField = 42;
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicMethodInResolvedPackagePrivateClass() builder (after)
  /// CHECK: InvokeUnresolved method_name:{{[^$]*}}$noinline$publicStaticMethod

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicMethodInResolvedPackagePrivateClass() builder (after)
  /// CHECK-NOT: InvokeStaticOrDirect method_name:{{[^$]*}}$noinline$publicStaticMethod
  static void $noinline$testPublicMethodInResolvedPackagePrivateClass() {
    try {
      ResolvedPackagePrivateClass.$noinline$publicStaticMethod();
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicMethodInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK: InvokeStaticOrDirect method_name:{{[^$]*}}$noinline$publicStaticMethod

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPublicMethodInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK-NOT: InvokeUnresolved method_name:{{[^$]*}}$noinline$publicStaticMethod
  static void $noinline$testPublicMethodInPackagePrivateClassViaResolvedPublicSubclass() {
    ResolvedPublicSubclassOfPackagePrivateClass.$noinline$publicStaticMethod();
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateMethodInResolvedPackagePrivateClass() builder (after)
  /// CHECK: InvokeUnresolved method_name:{{[^$]*}}$noinline$privateStaticMethod

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateMethodInResolvedPackagePrivateClass() builder (after)
  /// CHECK-NOT: InvokeStaticOrDirect method_name:{{[^$]*}}$noinline$privateStaticMethod
  static void $noinline$testPrivateMethodInResolvedPackagePrivateClass() {
    try {
      ResolvedPackagePrivateClass.$noinline$privateStaticMethod();
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateMethodInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK: InvokeUnresolved method_name:{{[^$]*}}$noinline$privateStaticMethod

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPrivateMethodInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK-NOT: InvokeStaticOrDirect method_name:{{[^$]*}}$noinline$privateStaticMethod
  static void $noinline$testPrivateMethodInPackagePrivateClassViaResolvedPublicSubclass() {
    try {
      ResolvedPublicSubclassOfPackagePrivateClass.$noinline$privateStaticMethod();
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateMethodInResolvedPackagePrivateClass() builder (after)
  /// CHECK: InvokeUnresolved method_name:{{[^$]*}}$noinline$staticMethod

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateMethodInResolvedPackagePrivateClass() builder (after)
  /// CHECK-NOT: InvokeStaticOrDirect method_name:{{[^$]*}}$noinline$staticMethod
  static void $noinline$testPackagePrivateMethodInResolvedPackagePrivateClass() {
    try {
      ResolvedPackagePrivateClass.$noinline$staticMethod();
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateMethodInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK: InvokeUnresolved method_name:{{[^$]*}}$noinline$staticMethod

  /// CHECK-START: void resolved.SubclassOfUnresolvedClass2.$noinline$testPackagePrivateMethodInPackagePrivateClassViaResolvedPublicSubclass() builder (after)
  /// CHECK-NOT: InvokeStaticOrDirect method_name:{{[^$]*}}$noinline$staticMethod
  static void $noinline$testPackagePrivateMethodInPackagePrivateClassViaResolvedPublicSubclass() {
    try {
      ResolvedPublicSubclassOfPackagePrivateClass.$noinline$staticMethod();
      throw new Error("Unreachable");
    } catch (IllegalAccessError expected) {}
  }
}
