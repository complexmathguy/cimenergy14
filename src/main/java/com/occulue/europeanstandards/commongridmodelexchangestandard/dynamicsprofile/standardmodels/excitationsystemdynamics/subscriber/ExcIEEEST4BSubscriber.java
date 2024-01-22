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
 * Subscriber for ExcIEEEST4B related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEST4B-subscriber")
public class ExcIEEEST4BSubscriber extends BaseSubscriber {

  public ExcIEEEST4BSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEST4B>, ExcIEEEST4B> excIEEEST4BSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEST4BQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEST4B.class),
        ResponseTypes.instanceOf(ExcIEEEST4B.class));
  }

  public SubscriptionQueryResult<ExcIEEEST4B, ExcIEEEST4B> excIEEEST4BSubscribe(
      @DestinationVariable UUID excIEEEST4BId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEST4BQuery(new LoadExcIEEEST4BFilter(excIEEEST4BId)),
        ResponseTypes.instanceOf(ExcIEEEST4B.class),
        ResponseTypes.instanceOf(ExcIEEEST4B.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
