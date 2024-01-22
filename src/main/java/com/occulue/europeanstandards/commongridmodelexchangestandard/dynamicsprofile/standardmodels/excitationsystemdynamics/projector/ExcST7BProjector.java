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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcST7B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcST7B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcST7BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excST7B")
@Component("excST7B-projector")
public class ExcST7BProjector extends ExcST7BEntityProjector {

  // core constructor
  public ExcST7BProjector(ExcST7BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcST7BEvent
   */
  @EventHandler(payloadType = CreateExcST7BEvent.class)
  public void handle(CreateExcST7BEvent event) {
    LOGGER.info("handling CreateExcST7BEvent - " + event);
    ExcST7B entity = new ExcST7B();
    entity.setExcST7BId(event.getExcST7BId());
    entity.setOelin(event.getOelin());
    entity.setUelin(event.getUelin());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UpdateExcST7BEvent
   */
  @EventHandler(payloadType = UpdateExcST7BEvent.class)
  public void handle(UpdateExcST7BEvent event) {
    LOGGER.info("handling UpdateExcST7BEvent - " + event);

    ExcST7B entity = new ExcST7B();
    entity.setExcST7BId(event.getExcST7BId());
    entity.setKh(event.getKh());
    entity.setKia(event.getKia());
    entity.setKl(event.getKl());
    entity.setKpa(event.getKpa());
    entity.setOelin(event.getOelin());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTf(event.getTf());
    entity.setTg(event.getTg());
    entity.setTia(event.getTia());
    entity.setTs(event.getTs());
    entity.setUelin(event.getUelin());
    entity.setVmax(event.getVmax());
    entity.setVmin(event.getVmin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event DeleteExcST7BEvent
   */
  @EventHandler(payloadType = DeleteExcST7BEvent.class)
  public void handle(DeleteExcST7BEvent event) {
    LOGGER.info("handling DeleteExcST7BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcST7B entity = delete(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignKhToExcST7BEvent
   */
  @EventHandler(payloadType = AssignKhToExcST7BEvent.class)
  public void handle(AssignKhToExcST7BEvent event) {
    LOGGER.info("handling AssignKhToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignKh(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignKhFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignKhFromExcST7BEvent.class)
  public void handle(UnAssignKhFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignKhFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignKh(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignKiaToExcST7BEvent
   */
  @EventHandler(payloadType = AssignKiaToExcST7BEvent.class)
  public void handle(AssignKiaToExcST7BEvent event) {
    LOGGER.info("handling AssignKiaToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignKia(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignKiaFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignKiaFromExcST7BEvent.class)
  public void handle(UnAssignKiaFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignKiaFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignKia(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignKlToExcST7BEvent
   */
  @EventHandler(payloadType = AssignKlToExcST7BEvent.class)
  public void handle(AssignKlToExcST7BEvent event) {
    LOGGER.info("handling AssignKlToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignKl(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignKlFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignKlFromExcST7BEvent.class)
  public void handle(UnAssignKlFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignKlFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignKl(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignKpaToExcST7BEvent
   */
  @EventHandler(payloadType = AssignKpaToExcST7BEvent.class)
  public void handle(AssignKpaToExcST7BEvent event) {
    LOGGER.info("handling AssignKpaToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignKpa(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignKpaFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignKpaFromExcST7BEvent.class)
  public void handle(UnAssignKpaFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignKpaFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignKpa(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignTbToExcST7BEvent
   */
  @EventHandler(payloadType = AssignTbToExcST7BEvent.class)
  public void handle(AssignTbToExcST7BEvent event) {
    LOGGER.info("handling AssignTbToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignTb(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignTbFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcST7BEvent.class)
  public void handle(UnAssignTbFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignTbFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignTb(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignTcToExcST7BEvent
   */
  @EventHandler(payloadType = AssignTcToExcST7BEvent.class)
  public void handle(AssignTcToExcST7BEvent event) {
    LOGGER.info("handling AssignTcToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignTc(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignTcFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcST7BEvent.class)
  public void handle(UnAssignTcFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignTcFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignTc(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignTfToExcST7BEvent
   */
  @EventHandler(payloadType = AssignTfToExcST7BEvent.class)
  public void handle(AssignTfToExcST7BEvent event) {
    LOGGER.info("handling AssignTfToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignTf(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignTfFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcST7BEvent.class)
  public void handle(UnAssignTfFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignTfFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignTf(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignTgToExcST7BEvent
   */
  @EventHandler(payloadType = AssignTgToExcST7BEvent.class)
  public void handle(AssignTgToExcST7BEvent event) {
    LOGGER.info("handling AssignTgToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignTg(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignTgFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignTgFromExcST7BEvent.class)
  public void handle(UnAssignTgFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignTgFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignTg(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignTiaToExcST7BEvent
   */
  @EventHandler(payloadType = AssignTiaToExcST7BEvent.class)
  public void handle(AssignTiaToExcST7BEvent event) {
    LOGGER.info("handling AssignTiaToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignTia(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignTiaFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignTiaFromExcST7BEvent.class)
  public void handle(UnAssignTiaFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignTiaFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignTia(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignTsToExcST7BEvent
   */
  @EventHandler(payloadType = AssignTsToExcST7BEvent.class)
  public void handle(AssignTsToExcST7BEvent event) {
    LOGGER.info("handling AssignTsToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignTs(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignTsFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignTsFromExcST7BEvent.class)
  public void handle(UnAssignTsFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignTsFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignTs(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignVmaxToExcST7BEvent
   */
  @EventHandler(payloadType = AssignVmaxToExcST7BEvent.class)
  public void handle(AssignVmaxToExcST7BEvent event) {
    LOGGER.info("handling AssignVmaxToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignVmax(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignVmaxFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignVmaxFromExcST7BEvent.class)
  public void handle(UnAssignVmaxFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignVmaxFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignVmax(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignVminToExcST7BEvent
   */
  @EventHandler(payloadType = AssignVminToExcST7BEvent.class)
  public void handle(AssignVminToExcST7BEvent event) {
    LOGGER.info("handling AssignVminToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignVmin(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignVminFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignVminFromExcST7BEvent.class)
  public void handle(UnAssignVminFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignVminFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignVmin(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcST7BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcST7BEvent.class)
  public void handle(AssignVrmaxToExcST7BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignVrmax(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcST7BEvent.class)
  public void handle(UnAssignVrmaxFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignVrmax(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event AssignVrminToExcST7BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcST7BEvent.class)
  public void handle(AssignVrminToExcST7BEvent event) {
    LOGGER.info("handling AssignVrminToExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST7B entity = assignVrmin(event.getExcST7BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcST7BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcST7BEvent.class)
  public void handle(UnAssignVrminFromExcST7BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcST7BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST7B entity = unAssignVrmin(event.getExcST7BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST7B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST7B(entity);
  }

  /**
   * Method to retrieve the ExcST7B via an ExcST7BPrimaryKey.
   *
   * @param id Long
   * @return ExcST7B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcST7B handle(FindExcST7BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcST7BId());
  }

  /**
   * Method to retrieve a collection of all ExcST7Bs
   *
   * @param query FindAllExcST7BQuery
   * @return List<ExcST7B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcST7B> handle(FindAllExcST7BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcST7B, but only if the id matches
   *
   * @param entity ExcST7B
   */
  protected void emitFindExcST7B(ExcST7B entity) {
    LOGGER.info("handling emitFindExcST7B");

    queryUpdateEmitter.emit(
        FindExcST7BQuery.class,
        query -> query.getFilter().getExcST7BId().equals(entity.getExcST7BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcST7B
   *
   * @param entity ExcST7B
   */
  protected void emitFindAllExcST7B(ExcST7B entity) {
    LOGGER.info("handling emitFindAllExcST7B");

    queryUpdateEmitter.emit(FindAllExcST7BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcST7BProjector.class.getName());
}
