/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for ValueToAlias related events. .
 *
 * @author your_name_here
 */
@Component("valueToAlias-subscriber")
public class ValueToAliasSubscriber extends BaseSubscriber {

  public ValueToAliasSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ValueToAlias>, ValueToAlias> valueToAliasSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllValueToAliasQuery(),
        ResponseTypes.multipleInstancesOf(ValueToAlias.class),
        ResponseTypes.instanceOf(ValueToAlias.class));
  }

  public SubscriptionQueryResult<ValueToAlias, ValueToAlias> valueToAliasSubscribe(
      @DestinationVariable UUID valueToAliasId) {
    return queryGateway.subscriptionQuery(
        new FindValueToAliasQuery(new LoadValueToAliasFilter(valueToAliasId)),
        ResponseTypes.instanceOf(ValueToAlias.class),
        ResponseTypes.instanceOf(ValueToAlias.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
