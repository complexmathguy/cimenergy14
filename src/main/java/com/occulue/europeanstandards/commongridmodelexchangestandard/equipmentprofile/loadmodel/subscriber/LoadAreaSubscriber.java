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
 * Subscriber for LoadArea related events. .
 *
 * @author your_name_here
 */
@Component("loadArea-subscriber")
public class LoadAreaSubscriber extends BaseSubscriber {

  public LoadAreaSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LoadArea>, LoadArea> loadAreaSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLoadAreaQuery(),
        ResponseTypes.multipleInstancesOf(LoadArea.class),
        ResponseTypes.instanceOf(LoadArea.class));
  }

  public SubscriptionQueryResult<LoadArea, LoadArea> loadAreaSubscribe(
      @DestinationVariable UUID loadAreaId) {
    return queryGateway.subscriptionQuery(
        new FindLoadAreaQuery(new LoadLoadAreaFilter(loadAreaId)),
        ResponseTypes.instanceOf(LoadArea.class),
        ResponseTypes.instanceOf(LoadArea.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
