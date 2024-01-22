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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for Bay as outlined for the CQRS pattern. All event handling and query handling related
 * to Bay are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by BayAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("bay")
@Component("bay-projector")
public class BayProjector extends BayEntityProjector {

  // core constructor
  public BayProjector(BayRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateBayEvent
   */
  @EventHandler(payloadType = CreateBayEvent.class)
  public void handle(CreateBayEvent event) {
    LOGGER.info("handling CreateBayEvent - " + event);
    Bay entity = new Bay();
    entity.setBayId(event.getBayId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBay(entity);
  }

  /*
   * @param	event UpdateBayEvent
   */
  @EventHandler(payloadType = UpdateBayEvent.class)
  public void handle(UpdateBayEvent event) {
    LOGGER.info("handling UpdateBayEvent - " + event);

    Bay entity = new Bay();
    entity.setBayId(event.getBayId());
    entity.setBays(event.getBays());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBay(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBay(entity);
  }

  /*
   * @param	event DeleteBayEvent
   */
  @EventHandler(payloadType = DeleteBayEvent.class)
  public void handle(DeleteBayEvent event) {
    LOGGER.info("handling DeleteBayEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    Bay entity = delete(event.getBayId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBay(entity);
  }

  /*
   * @param	event AssignBaysToBayEvent
   */
  @EventHandler(payloadType = AssignBaysToBayEvent.class)
  public void handle(AssignBaysToBayEvent event) {
    LOGGER.info("handling AssignBaysToBayEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    Bay entity = addToBays(event.getBayId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBay(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBay(entity);
  }

  /*
   * @param	event RemoveBaysFromBayEvent
   */
  @EventHandler(payloadType = RemoveBaysFromBayEvent.class)
  public void handle(RemoveBaysFromBayEvent event) {
    LOGGER.info("handling RemoveBaysFromBayEvent - " + event);

    Bay entity = removeFromBays(event.getBayId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindBay(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllBay(entity);
  }

  /**
   * Method to retrieve the Bay via an BayPrimaryKey.
   *
   * @param id Long
   * @return Bay
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public Bay handle(FindBayQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getBayId());
  }

  /**
   * Method to retrieve a collection of all Bays
   *
   * @param query FindAllBayQuery
   * @return List<Bay>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<Bay> handle(FindAllBayQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindBay, but only if the id matches
   *
   * @param entity Bay
   */
  protected void emitFindBay(Bay entity) {
    LOGGER.info("handling emitFindBay");

    queryUpdateEmitter.emit(
        FindBayQuery.class,
        query -> query.getFilter().getBayId().equals(entity.getBayId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllBay
   *
   * @param entity Bay
   */
  protected void emitFindAllBay(Bay entity) {
    LOGGER.info("handling emitFindAllBay");

    queryUpdateEmitter.emit(FindAllBayQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(BayProjector.class.getName());
}
