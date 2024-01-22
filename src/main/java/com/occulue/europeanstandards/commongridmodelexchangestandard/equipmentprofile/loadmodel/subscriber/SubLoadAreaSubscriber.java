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
 * Subscriber for SubLoadArea related events. .
 *
 * @author your_name_here
 */
@Component("subLoadArea-subscriber")
public class SubLoadAreaSubscriber extends BaseSubscriber {

  public SubLoadAreaSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SubLoadArea>, SubLoadArea> subLoadAreaSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSubLoadAreaQuery(),
        ResponseTypes.multipleInstancesOf(SubLoadArea.class),
        ResponseTypes.instanceOf(SubLoadArea.class));
  }

  public SubscriptionQueryResult<SubLoadArea, SubLoadArea> subLoadAreaSubscribe(
      @DestinationVariable UUID subLoadAreaId) {
    return queryGateway.subscriptionQuery(
        new FindSubLoadAreaQuery(new LoadSubLoadAreaFilter(subLoadAreaId)),
        ResponseTypes.instanceOf(SubLoadArea.class),
        ResponseTypes.instanceOf(SubLoadArea.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
