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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.subscriber;

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
 * Subscriber for SvShuntCompensatorSections related events. .
 *
 * @author your_name_here
 */
@Component("svShuntCompensatorSections-subscriber")
public class SvShuntCompensatorSectionsSubscriber extends BaseSubscriber {

  public SvShuntCompensatorSectionsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SvShuntCompensatorSections>, SvShuntCompensatorSections>
      svShuntCompensatorSectionsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSvShuntCompensatorSectionsQuery(),
        ResponseTypes.multipleInstancesOf(SvShuntCompensatorSections.class),
        ResponseTypes.instanceOf(SvShuntCompensatorSections.class));
  }

  public SubscriptionQueryResult<SvShuntCompensatorSections, SvShuntCompensatorSections>
      svShuntCompensatorSectionsSubscribe(@DestinationVariable UUID svShuntCompensatorSectionsId) {
    return queryGateway.subscriptionQuery(
        new FindSvShuntCompensatorSectionsQuery(
            new LoadSvShuntCompensatorSectionsFilter(svShuntCompensatorSectionsId)),
        ResponseTypes.instanceOf(SvShuntCompensatorSections.class),
        ResponseTypes.instanceOf(SvShuntCompensatorSections.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
