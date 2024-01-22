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
 * Subscriber for LoadGroup related events. .
 *
 * @author your_name_here
 */
@Component("loadGroup-subscriber")
public class LoadGroupSubscriber extends BaseSubscriber {

  public LoadGroupSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LoadGroup>, LoadGroup> loadGroupSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLoadGroupQuery(),
        ResponseTypes.multipleInstancesOf(LoadGroup.class),
        ResponseTypes.instanceOf(LoadGroup.class));
  }

  public SubscriptionQueryResult<LoadGroup, LoadGroup> loadGroupSubscribe(
      @DestinationVariable UUID loadGroupId) {
    return queryGateway.subscriptionQuery(
        new FindLoadGroupQuery(new LoadLoadGroupFilter(loadGroupId)),
        ResponseTypes.instanceOf(LoadGroup.class),
        ResponseTypes.instanceOf(LoadGroup.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
