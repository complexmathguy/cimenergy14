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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.discontinuousexcitationcontroldynamics.subscriber;

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
 * Subscriber for DiscExcContIEEEDEC2A related events. .
 *
 * @author your_name_here
 */
@Component("discExcContIEEEDEC2A-subscriber")
public class DiscExcContIEEEDEC2ASubscriber extends BaseSubscriber {

  public DiscExcContIEEEDEC2ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DiscExcContIEEEDEC2A>, DiscExcContIEEEDEC2A>
      discExcContIEEEDEC2ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDiscExcContIEEEDEC2AQuery(),
        ResponseTypes.multipleInstancesOf(DiscExcContIEEEDEC2A.class),
        ResponseTypes.instanceOf(DiscExcContIEEEDEC2A.class));
  }

  public SubscriptionQueryResult<DiscExcContIEEEDEC2A, DiscExcContIEEEDEC2A>
      discExcContIEEEDEC2ASubscribe(@DestinationVariable UUID discExcContIEEEDEC2AId) {
    return queryGateway.subscriptionQuery(
        new FindDiscExcContIEEEDEC2AQuery(
            new LoadDiscExcContIEEEDEC2AFilter(discExcContIEEEDEC2AId)),
        ResponseTypes.instanceOf(DiscExcContIEEEDEC2A.class),
        ResponseTypes.instanceOf(DiscExcContIEEEDEC2A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
