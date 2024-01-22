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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * Analog business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Analog related services in the case of a Analog business related
 *       service failing.
 *   <li>Exposes a simpler, uniform Analog interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Analog business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class AnalogBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public AnalogBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Analog Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return AnalogBusinessDelegate
   */
  public static AnalogBusinessDelegate getAnalogInstance() {
    return (new AnalogBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createAnalog(CreateAnalogCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getAnalogId() == null) command.setAnalogId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateAnalogCommand - by convention the future return value for a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateAnalogCommand of Analog is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Analog - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateAnalogCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateAnalog(UpdateAnalogCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      AnalogValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateAnalogCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Analog - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteAnalogCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteAnalogCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteAnalogCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Analog using Id = " + command.getAnalogId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Analog via AnalogFetchOneSummary
   *
   * @param summary AnalogFetchOneSummary
   * @return AnalogFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Analog getAnalog(AnalogFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("AnalogFetchOneSummary arg cannot be null");

    Analog entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      AnalogValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Analog
      // --------------------------------------
      CompletableFuture<Analog> futureEntity =
          queryGateway.query(
              new FindAnalogQuery(new LoadAnalogFilter(summary.getAnalogId())),
              ResponseTypes.instanceOf(Analog.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Analog with id " + summary.getAnalogId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Analogs
   *
   * @return List<Analog>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Analog> getAllAnalog() throws ProcessingException {
    List<Analog> list = null;

    try {
      CompletableFuture<List<Analog>> futureList =
          queryGateway.query(
              new FindAllAnalogQuery(), ResponseTypes.multipleInstancesOf(Analog.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Analog";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign PositiveFlowIn on Analog
   *
   * @param command AssignPositiveFlowInToAnalogCommand
   * @exception ProcessingException
   */
  public void assignPositiveFlowIn(AssignPositiveFlowInToAnalogCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getAnalogId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .BooleanProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .BooleanProxyBusinessDelegate.getBooleanProxyInstance();
    AnalogBusinessDelegate parentDelegate = AnalogBusinessDelegate.getAnalogInstance();
    UUID childId = command.getAssignment().getBooleanProxyId();
    BooleanProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      AnalogValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get BooleanProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign PositiveFlowIn on Analog
   *
   * @param command UnAssignPositiveFlowInFromAnalogCommand
   * @exception ProcessingException
   */
  public void unAssignPositiveFlowIn(UnAssignPositiveFlowInFromAnalogCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      AnalogValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign PositiveFlowIn on Analog";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return Analog
   */
  private Analog load(UUID id) throws ProcessingException {
    analog = AnalogBusinessDelegate.getAnalogInstance().getAnalog(new AnalogFetchOneSummary(id));
    return analog;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Analog analog = null;
  private static final Logger LOGGER = Logger.getLogger(AnalogBusinessDelegate.class.getName());
}
