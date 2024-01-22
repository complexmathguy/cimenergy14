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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.subscriber;

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
 * Subscriber for NonConformLoadGroup related events. .
 *
 * @author your_name_here
 */
@Component("nonConformLoadGroup-subscriber")
public class NonConformLoadGroupSubscriber extends BaseSubscriber {

  public NonConformLoadGroupSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<NonConformLoadGroup>, NonConformLoadGroup>
      nonConformLoadGroupSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllNonConformLoadGroupQuery(),
        ResponseTypes.multipleInstancesOf(NonConformLoadGroup.class),
        ResponseTypes.instanceOf(NonConformLoadGroup.class));
  }

  public SubscriptionQueryResult<NonConformLoadGroup, NonConformLoadGroup>
      nonConformLoadGroupSubscribe(@DestinationVariable UUID nonConformLoadGroupId) {
    return queryGateway.subscriptionQuery(
        new FindNonConformLoadGroupQuery(new LoadNonConformLoadGroupFilter(nonConformLoadGroupId)),
        ResponseTypes.instanceOf(NonConformLoadGroup.class),
        ResponseTypes.instanceOf(NonConformLoadGroup.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
