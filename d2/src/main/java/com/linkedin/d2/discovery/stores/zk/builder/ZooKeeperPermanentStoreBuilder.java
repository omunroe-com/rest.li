/*
   Copyright (c) 2017 LinkedIn Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.linkedin.d2.discovery.stores.zk.builder;

import com.linkedin.d2.discovery.PropertySerializer;
import com.linkedin.d2.discovery.stores.zk.ZKConnection;
import com.linkedin.d2.discovery.stores.zk.ZooKeeperPermanentStore;

/**
 * Builder class for {@link ZooKeeperPermanentStore}
 *
 * @author Francesco Capponi (fcapponi@linkedin.com)
 */
public class ZooKeeperPermanentStoreBuilder<T> implements ZooKeeperStoreBuilder<ZooKeeperPermanentStore<T>>
{
  private ZKConnection client;
  private PropertySerializer<T> serializer;
  private String path;

  public void setZkConnection(ZKConnection client)
  {
    this.client = client;
  }

  public ZooKeeperPermanentStoreBuilder<T> setSerializer(PropertySerializer<T> serializer)
  {
    this.serializer = serializer;
    return this;
  }

  public ZooKeeperPermanentStoreBuilder<T> setPath(String path)
  {
    this.path = path;
    return this;
  }

  @Override
  public ZooKeeperPermanentStore<T> build()
  {
    return new ZooKeeperPermanentStore<>(client, serializer, path);
  }


}