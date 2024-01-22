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
 * Subscriber for ExcIEEEDC1A related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEDC1A-subscriber")
public class ExcIEEEDC1ASubscriber extends BaseSubscriber {

  public ExcIEEEDC1ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEDC1A>, ExcIEEEDC1A> excIEEEDC1ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEDC1AQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEDC1A.class),
        ResponseTypes.instanceOf(ExcIEEEDC1A.class));
  }

  public SubscriptionQueryResult<ExcIEEEDC1A, ExcIEEEDC1A> excIEEEDC1ASubscribe(
      @DestinationVariable UUID excIEEEDC1AId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEDC1AQuery(new LoadExcIEEEDC1AFilter(excIEEEDC1AId)),
        ResponseTypes.instanceOf(ExcIEEEDC1A.class),
        ResponseTypes.instanceOf(ExcIEEEDC1A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
