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
 * Projector for ExcIEEEST5B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEST5B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEST5BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEST5B")
@Component("excIEEEST5B-projector")
public class ExcIEEEST5BProjector extends ExcIEEEST5BEntityProjector {

  // core constructor
  public ExcIEEEST5BProjector(
      ExcIEEEST5BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEST5BEvent
   */
  @EventHandler(payloadType = CreateExcIEEEST5BEvent.class)
  public void handle(CreateExcIEEEST5BEvent event) {
    LOGGER.info("handling CreateExcIEEEST5BEvent - " + event);
    ExcIEEEST5B entity = new ExcIEEEST5B();
    entity.setExcIEEEST5BId(event.getExcIEEEST5BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UpdateExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEST5BEvent.class)
  public void handle(UpdateExcIEEEST5BEvent event) {
    LOGGER.info("handling UpdateExcIEEEST5BEvent - " + event);

    ExcIEEEST5B entity = new ExcIEEEST5B();
    entity.setExcIEEEST5BId(event.getExcIEEEST5BId());
    entity.setKc(event.getKc());
    entity.setKr(event.getKr());
    entity.setT1(event.getT1());
    entity.setTb1(event.getTb1());
    entity.setTb2(event.getTb2());
    entity.setTc1(event.getTc1());
    entity.setTc2(event.getTc2());
    entity.setTob1(event.getTob1());
    entity.setTob2(event.getTob2());
    entity.setToc1(event.getToc1());
    entity.setToc2(event.getToc2());
    entity.setTub1(event.getTub1());
    entity.setTub2(event.getTub2());
    entity.setTuc1(event.getTuc1());
    entity.setTuc2(event.getTuc2());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event DeleteExcIEEEST5BEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEST5BEvent.class)
  public void handle(DeleteExcIEEEST5BEvent event) {
    LOGGER.info("handling DeleteExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEST5B entity = delete(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEST5BEvent.class)
  public void handle(AssignKcToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignKc(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEST5BEvent.class)
  public void handle(UnAssignKcFromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignKc(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignKrToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignKrToExcIEEEST5BEvent.class)
  public void handle(AssignKrToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignKrToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignKr(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignKrFromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignKrFromExcIEEEST5BEvent.class)
  public void handle(UnAssignKrFromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignKrFromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignKr(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignT1ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignT1ToExcIEEEST5BEvent.class)
  public void handle(AssignT1ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignT1ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignT1(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignT1FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignT1FromExcIEEEST5BEvent.class)
  public void handle(UnAssignT1FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignT1FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignT1(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTb1ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTb1ToExcIEEEST5BEvent.class)
  public void handle(AssignTb1ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTb1ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTb1(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTb1FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTb1FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTb1FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTb1FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTb1(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTb2ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTb2ToExcIEEEST5BEvent.class)
  public void handle(AssignTb2ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTb2ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTb2(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTb2FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTb2FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTb2FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTb2FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTb2(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTc1ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTc1ToExcIEEEST5BEvent.class)
  public void handle(AssignTc1ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTc1ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTc1(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTc1FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTc1FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTc1FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTc1FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTc1(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTc2ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTc2ToExcIEEEST5BEvent.class)
  public void handle(AssignTc2ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTc2ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTc2(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTc2FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTc2FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTc2FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTc2FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTc2(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTob1ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTob1ToExcIEEEST5BEvent.class)
  public void handle(AssignTob1ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTob1ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTob1(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTob1FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTob1FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTob1FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTob1FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTob1(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTob2ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTob2ToExcIEEEST5BEvent.class)
  public void handle(AssignTob2ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTob2ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTob2(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTob2FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTob2FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTob2FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTob2FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTob2(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignToc1ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignToc1ToExcIEEEST5BEvent.class)
  public void handle(AssignToc1ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignToc1ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignToc1(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignToc1FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignToc1FromExcIEEEST5BEvent.class)
  public void handle(UnAssignToc1FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignToc1FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignToc1(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignToc2ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignToc2ToExcIEEEST5BEvent.class)
  public void handle(AssignToc2ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignToc2ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignToc2(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignToc2FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignToc2FromExcIEEEST5BEvent.class)
  public void handle(UnAssignToc2FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignToc2FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignToc2(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTub1ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTub1ToExcIEEEST5BEvent.class)
  public void handle(AssignTub1ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTub1ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTub1(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTub1FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTub1FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTub1FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTub1FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTub1(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTub2ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTub2ToExcIEEEST5BEvent.class)
  public void handle(AssignTub2ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTub2ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTub2(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTub2FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTub2FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTub2FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTub2FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTub2(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTuc1ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTuc1ToExcIEEEST5BEvent.class)
  public void handle(AssignTuc1ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTuc1ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTuc1(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTuc1FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTuc1FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTuc1FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTuc1FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTuc1(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignTuc2ToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignTuc2ToExcIEEEST5BEvent.class)
  public void handle(AssignTuc2ToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignTuc2ToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignTuc2(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignTuc2FromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignTuc2FromExcIEEEST5BEvent.class)
  public void handle(UnAssignTuc2FromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignTuc2FromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignTuc2(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEST5BEvent.class)
  public void handle(AssignVrmaxToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignVrmax(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEST5BEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignVrmax(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEST5BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEST5BEvent.class)
  public void handle(AssignVrminToExcIEEEST5BEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST5B entity = assignVrmin(event.getExcIEEEST5BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEST5BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEST5BEvent.class)
  public void handle(UnAssignVrminFromExcIEEEST5BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEST5BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST5B entity = unAssignVrmin(event.getExcIEEEST5BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST5B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST5B(entity);
  }

  /**
   * Method to retrieve the ExcIEEEST5B via an ExcIEEEST5BPrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEST5B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEST5B handle(FindExcIEEEST5BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEST5BId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST5Bs
   *
   * @param query FindAllExcIEEEST5BQuery
   * @return List<ExcIEEEST5B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEST5B> handle(FindAllExcIEEEST5BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEST5B, but only if the id matches
   *
   * @param entity ExcIEEEST5B
   */
  protected void emitFindExcIEEEST5B(ExcIEEEST5B entity) {
    LOGGER.info("handling emitFindExcIEEEST5B");

    queryUpdateEmitter.emit(
        FindExcIEEEST5BQuery.class,
        query -> query.getFilter().getExcIEEEST5BId().equals(entity.getExcIEEEST5BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEST5B
   *
   * @param entity ExcIEEEST5B
   */
  protected void emitFindAllExcIEEEST5B(ExcIEEEST5B entity) {
    LOGGER.info("handling emitFindAllExcIEEEST5B");

    queryUpdateEmitter.emit(FindAllExcIEEEST5BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST5BProjector.class.getName());
}
