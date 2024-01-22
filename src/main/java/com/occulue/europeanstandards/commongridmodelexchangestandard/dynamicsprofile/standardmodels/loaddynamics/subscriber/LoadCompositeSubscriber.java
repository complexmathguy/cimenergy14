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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.subscriber;

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
 * Subscriber for LoadComposite related events. .
 *
 * @author your_name_here
 */
@Component("loadComposite-subscriber")
public class LoadCompositeSubscriber extends BaseSubscriber {

  public LoadCompositeSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LoadComposite>, LoadComposite> loadCompositeSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLoadCompositeQuery(),
        ResponseTypes.multipleInstancesOf(LoadComposite.class),
        ResponseTypes.instanceOf(LoadComposite.class));
  }

  public SubscriptionQueryResult<LoadComposite, LoadComposite> loadCompositeSubscribe(
      @DestinationVariable UUID loadCompositeId) {
    return queryGateway.subscriptionQuery(
        new FindLoadCompositeQuery(new LoadLoadCompositeFilter(loadCompositeId)),
        ResponseTypes.instanceOf(LoadComposite.class),
        ResponseTypes.instanceOf(LoadComposite.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
