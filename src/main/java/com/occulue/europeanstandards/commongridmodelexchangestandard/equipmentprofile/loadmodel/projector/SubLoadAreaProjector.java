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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for SubLoadArea as outlined for the CQRS pattern. All event handling and query handling
 * related to SubLoadArea are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by SubLoadAreaAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("subLoadArea")
@Component("subLoadArea-projector")
public class SubLoadAreaProjector extends SubLoadAreaEntityProjector {

  // core constructor
  public SubLoadAreaProjector(
      SubLoadAreaRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateSubLoadAreaEvent
   */
  @EventHandler(payloadType = CreateSubLoadAreaEvent.class)
  public void handle(CreateSubLoadAreaEvent event) {
    LOGGER.info("handling CreateSubLoadAreaEvent - " + event);
    SubLoadArea entity = new SubLoadArea();
    entity.setSubLoadAreaId(event.getSubLoadAreaId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSubLoadArea(entity);
  }

  /*
   * @param	event UpdateSubLoadAreaEvent
   */
  @EventHandler(payloadType = UpdateSubLoadAreaEvent.class)
  public void handle(UpdateSubLoadAreaEvent event) {
    LOGGER.info("handling UpdateSubLoadAreaEvent - " + event);

    SubLoadArea entity = new SubLoadArea();
    entity.setSubLoadAreaId(event.getSubLoadAreaId());
    entity.setSubLoadAreas(event.getSubLoadAreas());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSubLoadArea(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSubLoadArea(entity);
  }

  /*
   * @param	event DeleteSubLoadAreaEvent
   */
  @EventHandler(payloadType = DeleteSubLoadAreaEvent.class)
  public void handle(DeleteSubLoadAreaEvent event) {
    LOGGER.info("handling DeleteSubLoadAreaEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    SubLoadArea entity = delete(event.getSubLoadAreaId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSubLoadArea(entity);
  }

  /*
   * @param	event AssignSubLoadAreasToSubLoadAreaEvent
   */
  @EventHandler(payloadType = AssignSubLoadAreasToSubLoadAreaEvent.class)
  public void handle(AssignSubLoadAreasToSubLoadAreaEvent event) {
    LOGGER.info("handling AssignSubLoadAreasToSubLoadAreaEvent - " + event);

    // ------------------------------------------
    // delegate to addTo
    // ------------------------------------------
    SubLoadArea entity = addToSubLoadAreas(event.getSubLoadAreaId(), event.getAddTo());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSubLoadArea(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSubLoadArea(entity);
  }

  /*
   * @param	event RemoveSubLoadAreasFromSubLoadAreaEvent
   */
  @EventHandler(payloadType = RemoveSubLoadAreasFromSubLoadAreaEvent.class)
  public void handle(RemoveSubLoadAreasFromSubLoadAreaEvent event) {
    LOGGER.info("handling RemoveSubLoadAreasFromSubLoadAreaEvent - " + event);

    SubLoadArea entity = removeFromSubLoadAreas(event.getSubLoadAreaId(), event.getRemoveFrom());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindSubLoadArea(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllSubLoadArea(entity);
  }

  /**
   * Method to retrieve the SubLoadArea via an SubLoadAreaPrimaryKey.
   *
   * @param id Long
   * @return SubLoadArea
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public SubLoadArea handle(FindSubLoadAreaQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getSubLoadAreaId());
  }

  /**
   * Method to retrieve a collection of all SubLoadAreas
   *
   * @param query FindAllSubLoadAreaQuery
   * @return List<SubLoadArea>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<SubLoadArea> handle(FindAllSubLoadAreaQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindSubLoadArea, but only if the id matches
   *
   * @param entity SubLoadArea
   */
  protected void emitFindSubLoadArea(SubLoadArea entity) {
    LOGGER.info("handling emitFindSubLoadArea");

    queryUpdateEmitter.emit(
        FindSubLoadAreaQuery.class,
        query -> query.getFilter().getSubLoadAreaId().equals(entity.getSubLoadAreaId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllSubLoadArea
   *
   * @param entity SubLoadArea
   */
  protected void emitFindAllSubLoadArea(SubLoadArea entity) {
    LOGGER.info("handling emitFindAllSubLoadArea");

    queryUpdateEmitter.emit(FindAllSubLoadAreaQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(SubLoadAreaProjector.class.getName());
}
