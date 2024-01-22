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
 * Subscriber for ExcST3A related events. .
 *
 * @author your_name_here
 */
@Component("excST3A-subscriber")
public class ExcST3ASubscriber extends BaseSubscriber {

  public ExcST3ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcST3A>, ExcST3A> excST3ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcST3AQuery(),
        ResponseTypes.multipleInstancesOf(ExcST3A.class),
        ResponseTypes.instanceOf(ExcST3A.class));
  }

  public SubscriptionQueryResult<ExcST3A, ExcST3A> excST3ASubscribe(
      @DestinationVariable UUID excST3AId) {
    return queryGateway.subscriptionQuery(
        new FindExcST3AQuery(new LoadExcST3AFilter(excST3AId)),
        ResponseTypes.instanceOf(ExcST3A.class),
        ResponseTypes.instanceOf(ExcST3A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
