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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

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
 * Subscriber for ExcST7B related events. .
 *
 * @author your_name_here
 */
@Component("excST7B-subscriber")
public class ExcST7BSubscriber extends BaseSubscriber {

  public ExcST7BSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcST7B>, ExcST7B> excST7BSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcST7BQuery(),
        ResponseTypes.multipleInstancesOf(ExcST7B.class),
        ResponseTypes.instanceOf(ExcST7B.class));
  }

  public SubscriptionQueryResult<ExcST7B, ExcST7B> excST7BSubscribe(
      @DestinationVariable UUID excST7BId) {
    return queryGateway.subscriptionQuery(
        new FindExcST7BQuery(new LoadExcST7BFilter(excST7BId)),
        ResponseTypes.instanceOf(ExcST7B.class),
        ResponseTypes.instanceOf(ExcST7B.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
