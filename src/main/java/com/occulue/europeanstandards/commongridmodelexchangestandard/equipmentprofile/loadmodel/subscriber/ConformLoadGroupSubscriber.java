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
 * Subscriber for ConformLoadGroup related events. .
 *
 * @author your_name_here
 */
@Component("conformLoadGroup-subscriber")
public class ConformLoadGroupSubscriber extends BaseSubscriber {

  public ConformLoadGroupSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ConformLoadGroup>, ConformLoadGroup>
      conformLoadGroupSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllConformLoadGroupQuery(),
        ResponseTypes.multipleInstancesOf(ConformLoadGroup.class),
        ResponseTypes.instanceOf(ConformLoadGroup.class));
  }

  public SubscriptionQueryResult<ConformLoadGroup, ConformLoadGroup> conformLoadGroupSubscribe(
      @DestinationVariable UUID conformLoadGroupId) {
    return queryGateway.subscriptionQuery(
        new FindConformLoadGroupQuery(new LoadConformLoadGroupFilter(conformLoadGroupId)),
        ResponseTypes.instanceOf(ConformLoadGroup.class),
        ResponseTypes.instanceOf(ConformLoadGroup.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
