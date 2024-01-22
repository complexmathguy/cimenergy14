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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator.*;
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
 * WindPlantIEC business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of WindPlantIEC related services in the case of a WindPlantIEC
 *       business related service failing.
 *   <li>Exposes a simpler, uniform WindPlantIEC interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill WindPlantIEC business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class WindPlantIECBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public WindPlantIECBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * WindPlantIEC Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return WindPlantIECBusinessDelegate
   */
  public static WindPlantIECBusinessDelegate getWindPlantIECInstance() {
    return (new WindPlantIECBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createWindPlantIEC(CreateWindPlantIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getWindPlantIECId() == null) command.setWindPlantIECId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantIECValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateWindPlantIECCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateWindPlantIECCommand of WindPlantIEC is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create WindPlantIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateWindPlantIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateWindPlantIEC(UpdateWindPlantIECCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      WindPlantIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateWindPlantIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save WindPlantIEC - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteWindPlantIECCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteWindPlantIECCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteWindPlantIECCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete WindPlantIEC using Id = " + command.getWindPlantIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the WindPlantIEC via WindPlantIECFetchOneSummary
   *
   * @param summary WindPlantIECFetchOneSummary
   * @return WindPlantIECFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public WindPlantIEC getWindPlantIEC(WindPlantIECFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("WindPlantIECFetchOneSummary arg cannot be null");

    WindPlantIEC entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      WindPlantIECValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a WindPlantIEC
      // --------------------------------------
      CompletableFuture<WindPlantIEC> futureEntity =
          queryGateway.query(
              new FindWindPlantIECQuery(new LoadWindPlantIECFilter(summary.getWindPlantIECId())),
              ResponseTypes.instanceOf(WindPlantIEC.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate WindPlantIEC with id " + summary.getWindPlantIECId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all WindPlantIECs
   *
   * @return List<WindPlantIEC>
   * @exception ProcessingException Thrown if any problems
   */
  public List<WindPlantIEC> getAllWindPlantIEC() throws ProcessingException {
    List<WindPlantIEC> list = null;

    try {
      CompletableFuture<List<WindPlantIEC>> futureList =
          queryGateway.query(
              new FindAllWindPlantIECQuery(),
              ResponseTypes.multipleInstancesOf(WindPlantIEC.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all WindPlantIEC";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign WindPlantIEC on WindPlantIEC
   *
   * @param command AssignWindPlantIECToWindPlantIECCommand
   * @exception ProcessingException
   */
  public void assignWindPlantIEC(AssignWindPlantIECToWindPlantIECCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getWindPlantIECId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels
            .winddynamics.delegate.WindPlantIECBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile
                .standardmodels.winddynamics.delegate.WindPlantIECBusinessDelegate
                .getWindPlantIECInstance();
    WindPlantIECBusinessDelegate parentDelegate =
        WindPlantIECBusinessDelegate.getWindPlantIECInstance();
    UUID childId = command.getAssignment().getWindPlantIECId();
    WindPlantIEC child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      WindPlantIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get WindPlantIEC using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign WindPlantIEC on WindPlantIEC
   *
   * @param command UnAssignWindPlantIECFromWindPlantIECCommand
   * @exception ProcessingException
   */
  public void unAssignWindPlantIEC(UnAssignWindPlantIECFromWindPlantIECCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      WindPlantIECValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign WindPlantIEC on WindPlantIEC";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return WindPlantIEC
   */
  private WindPlantIEC load(UUID id) throws ProcessingException {
    windPlantIEC =
        WindPlantIECBusinessDelegate.getWindPlantIECInstance()
            .getWindPlantIEC(new WindPlantIECFetchOneSummary(id));
    return windPlantIEC;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private WindPlantIEC windPlantIEC = null;
  private static final Logger LOGGER =
      Logger.getLogger(WindPlantIECBusinessDelegate.class.getName());
}
