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
 * Subscriber for ExcIEEEAC7B related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEAC7B-subscriber")
public class ExcIEEEAC7BSubscriber extends BaseSubscriber {

  public ExcIEEEAC7BSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEAC7B>, ExcIEEEAC7B> excIEEEAC7BSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEAC7BQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEAC7B.class),
        ResponseTypes.instanceOf(ExcIEEEAC7B.class));
  }

  public SubscriptionQueryResult<ExcIEEEAC7B, ExcIEEEAC7B> excIEEEAC7BSubscribe(
      @DestinationVariable UUID excIEEEAC7BId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEAC7BQuery(new LoadExcIEEEAC7BFilter(excIEEEAC7BId)),
        ResponseTypes.instanceOf(ExcIEEEAC7B.class),
        ResponseTypes.instanceOf(ExcIEEEAC7B.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
